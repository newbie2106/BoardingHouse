/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services.impl;

import com.tth.pojo.Images;
import com.tth.pojo.Lessor;
import com.tth.pojo.Users;
import com.tth.repositories.ImagesRepository;
import com.tth.repositories.LessorRepository;
import com.tth.repositories.UserRepository;
import com.tth.services.ImagesService;
import com.tth.services.LessorService;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author tongh
 */
@Service
public class LessorServiceImpl implements LessorService {

    @Autowired
    private LessorRepository lessorRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ImagesService imagesService;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<Object[]> GetUnapprovedUsers() {
        return this.lessorRepo.GetUnapprovedUsers();
    }

    @Override
    public void approveUser(int id) {
        this.lessorRepo.approveUser(id);
    }

    @Override
    public Lessor getLessorById(int id) {
        return this.lessorRepo.getLessorById(id);
    }

    @Override
    public void deleteLessor(int id) {
        this.lessorRepo.deleteLessor(id);
    }

    @Override
    public List<Lessor> GetLessorDetails(int id) {
        return this.lessorRepo.GetLessorDetails(id);

    }

    @Override
    public List<Images> GetLessorImages(int id) {
        return this.lessorRepo.GetLessorImages(id);
    }

    @Override
    public void addLessor(Map<String, String> params, List<MultipartFile> images, Users user) {
        Lessor lessor = new Lessor();

        lessor.setCccd(params.get("cccd"));
        lessor.setId(user.getId());
        lessor.setUsers(user);
        this.lessorRepo.addLessor(lessor);
        if (images.size() > 0) {

            for (MultipartFile img : images) {
                Images i = new Images();
                //i.setImage(img.getName());
                i.setLessorId(lessor);
                i.setFile(img);
                this.imagesService.addImage(i);
            }
        }

    }

//    @Override
//    public boolean addLessorUser(Map<String, String> params, MultipartFile avatar, List<MultipartFile> files) {
//        try {
//            this.userService.addUser(params, avatar);
//            addLessor(params, files);
//            return true;
//        } catch (ValidationException ex) {
//            throw new ValidationException(ex.getMessage());
//        }
//    }
}
