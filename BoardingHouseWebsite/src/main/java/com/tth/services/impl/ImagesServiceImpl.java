/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tth.pojo.Images;
import com.tth.repositories.ImagesRepository;
import com.tth.services.ImagesService;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tongh
 */
@Service
public class ImagesServiceImpl implements ImagesService {

    @Autowired
    Cloudinary cloudinary;
    @Autowired
    ImagesRepository imageRepository;

    @Override
    public void addImage(Images image) {
        if (!image.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(image.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                image.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        this.imageRepository.addImage(image);
    }
}
