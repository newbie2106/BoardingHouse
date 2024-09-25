/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories;

import com.tth.pojo.Images;
import com.tth.pojo.Lessor;
import java.util.List;

/**
 *
 * @author tongh
 */
public interface LessorRepository {

    public void deleteLessor(int id);

    List<Object[]> GetUnapprovedUsers();

    public void approveUser(int id);

    Lessor getLessorById(int id);

    List<Lessor> GetLessorDetails(int id);

    public List<Images> GetLessorImages(int id);

    public boolean addLessor(Lessor lessor);

}
