package com.porfolio.api.Dao;

import com.porfolio.api.Util.Models.Skill;

import java.util.List;

public interface SkillInterfaceDao {
    List<Skill> getSkills();
    Skill getSkill(Long id);
    Skill newSkill(Skill skill);
    boolean deleteSkill(Long id);
    boolean updateSkill(Skill skill);
}
