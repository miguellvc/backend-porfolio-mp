package com.porfolio.api.Dao;

import com.porfolio.api.Models.Skill;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional

public class SkillDao implements SkillInterfaceDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Skill> getSkills() {
        String query = "FROM Skill";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Skill getSkill(Long id) {
        return null;
    }

    @Override
    public Skill newSkill(Skill project) {
        return null;
    }

    @Override
    public boolean deleteSkill(Long id) {
        return false;
    }
}
