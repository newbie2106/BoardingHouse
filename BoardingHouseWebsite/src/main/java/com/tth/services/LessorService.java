/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services;

import com.tth.pojo.Images;
import com.tth.pojo.Lessor;
import com.tth.pojo.Users;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author tongh
 */

public interface LessorService {

    public void deleteLessor(int id);

    List<Object[]> GetUnapprovedUsers();

    public void approveUser(int id);

    Lessor getLessorById(int id);

    List<Lessor> GetLessorDetails(int id);  

    public List<Images> GetLessorImages(int id);
    
    public void addLessor(Map<String, String> params, List<MultipartFile> files, Users user);
    
    //boolean addLessorUser(Map<String, String> params, MultipartFile avatar, List<MultipartFile> files);
}
