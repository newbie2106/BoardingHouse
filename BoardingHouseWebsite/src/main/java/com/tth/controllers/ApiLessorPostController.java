/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.controllers;

import com.tth.advice.ValidationException;
import com.tth.pojo.Area;
import com.tth.pojo.Customers;
import com.tth.pojo.Images;
import com.tth.pojo.Lessor;
import com.tth.pojo.LessorPost;
import com.tth.pojo.Post;
import com.tth.pojo.Users;
import com.tth.services.AreaService;
import com.tth.services.FollowService;
import com.tth.services.ImagesService;
import com.tth.services.LessorPostService;
import com.tth.services.LessorService;
import com.tth.services.PostService;
import com.tth.services.UserService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author tongh
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiLessorPostController {

    @Autowired
    private LessorPostService lessorPostService;

    @Autowired
    private UserService userService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private LessorService lessorService;

    @Autowired
    private ImagesService imagesService;

    @Autowired
    private FollowService followService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private PostService postService;

    @GetMapping("/lessor-post/")
    public ResponseEntity<List<Object[]>> list(@RequestParam Map<String, String> params) {

        return new ResponseEntity<>(this.lessorPostService.getLessorPosts(params), HttpStatus.OK);
    }

    @GetMapping(path = "/lessor-post/{lessorPostId}/", produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LessorPost> getLessorPostById(@PathVariable(value = "lessorPostId") int id) {
        return new ResponseEntity<>(this.lessorPostService.getLessorPostById(id), HttpStatus.OK);
    }

    @DeleteMapping("/lessor-post/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLessorPost(@PathVariable(value = "id") int id) {
        this.lessorPostService.deleteLessorPost(id);
    }

    @PostMapping(path = "/lessor-post/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Post> createLessorPost(@RequestParam Map<String, String> params,
            @RequestParam("files") List<MultipartFile> images,
            Principal u) {

        Users user = userService.getUserByUsername(u.getName());
        Area area = areaService.getAreaById(Integer.parseInt(params.get("areaId")));
        Lessor lessor = lessorService.getLessorById(user.getLessor().getId());

        Post post = new Post();
        post.setTitle(params.get("title"));
        post.setDescription(params.get("description"));
        post.setCreatedDate(new Date());

        if (this.postService.createPost(post)) {
            LessorPost lp = new LessorPost();
            lp.setId(post.getId());
            lp.setLocation(params.get("location"));
            lp.setQuantity(Integer.parseInt(params.get("quantity")));
            lp.setPrice(Float.parseFloat(params.get("price")));
            lp.setAreaId(area);
            lp.setLessorId(lessor);
            try {
                this.lessorPostService.createLessorPost(lp);

                if (images.size() > 0) {
                    for (MultipartFile image : images) {
                        Images i = new Images();
                        i.setImage(image.getName());
                        i.setPostId(post);
                        i.setFile(image);
                        this.imagesService.addImage(i);
                    }
                }
                Lessor l = this.lessorService.getLessorById(user.getId());
                List<Customers> list = this.followService.getFollowerByLessorId(l.getId());
                if (list.size() > 0) {
                    list.forEach(customer -> {
                        MimeMessage message = javaMailSender.createMimeMessage();
                        try {
                            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
                            helper.setTo(customer.getUsers().getEmail());
                            helper.setSubject("Thông báo từ " + l.getUsers().getFirstName()
                                    + " " + l.getUsers().getLastName() + ": " + post.getTitle());

                            String content = String.format("%s %s: %s\n\nGiá: %.2f\nVị trí: %s",
                                    l.getUsers().getFirstName(), l.getUsers().getLastName(), post.getTitle(),
                                    lp.getPrice(), lp.getLocation());

                            helper.setText(content, true);
                            javaMailSender.send(message);
                        } catch (MessagingException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }

                return new ResponseEntity<>(post, HttpStatus.CREATED);

            } catch (ValidationException ve) {
                Map<String, List<String>> errors = ve.getErrors();
                Map<String, List<String>> errorsRes = new HashMap<>();
                errors.forEach((key, value) -> {
                    List<String> listErr = new ArrayList<>();
                    for (String errCode : value) {
                        listErr.add(messageSource.getMessage(errCode, null, Locale.getDefault()));
                    }
                    errorsRes.put(key, listErr);
                });
                return new ResponseEntity(errorsRes, HttpStatus.BAD_REQUEST);
            }

        }
        return new ResponseEntity("ERROR", HttpStatus.BAD_REQUEST);

    }
}
