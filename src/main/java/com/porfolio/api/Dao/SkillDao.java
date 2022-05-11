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

        Skill skill = entityManager.find(Skill.class, id);
        return skill;
    }

    @Override
    public Skill newSkill(Skill skill) {

        try {
            Skill skillDB = entityManager.merge(skill);
            return skillDB;
        }catch (Exception e) {
            return null;
        }


    }

    @Override
    public boolean deleteSkill(Long id) {
        try {
                Skill skill = entityManager.find(Skill.class, id);
                entityManager.remove(skill);
                return true;
        }catch (Exception e) {
                return false;
        }
    }

    @Override
    public boolean updateSkill(Skill skill) {

        Skill newSkill = new Skill();

        newSkill.setId(skill.getId());

        return false;
    }
}
