package com.porfolio.api.Dao;

import com.porfolio.api.Util.Models.Education;

import java.util.List;

public interface EducationInterfaceDao {

    List<Education> getEducations();
    Education getEducation(Long id);
    Education newEducation(Education education);
    boolean deleteEducation(Long id);
    boolean updateEducation(Education education);
}
