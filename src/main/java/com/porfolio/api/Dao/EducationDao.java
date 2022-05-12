package com.porfolio.api.Dao;

import com.porfolio.api.Util.Models.Education;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional

public class EducationDao implements EducationInterfaceDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Education> getEducations() {
        String query = "FROM Education";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Education getEducation(Long id) {
        Education education = entityManager.find(Education.class, id);
        return education;
    }

    @Override
    public Education newEducation(Education education) {
        try{
            Education educationDB = entityManager.merge(education);
            return educationDB;
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean deleteEducation(Long id) {
        try{
            Education education = entityManager.find(Education.class, id);
            entityManager.remove(education);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean updateEducation(Education education) {

        try{
            Education newEducation = new Education();
            newEducation.setId(education.getId());
            newEducation.setCertificate(education.getCertificate());
            newEducation.setDescription(education.getDescription());
            newEducation.setYear(education.getYear());
            newEducation.setColor(education.getColor());
            entityManager.merge(education);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
