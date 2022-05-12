package com.porfolio.api.Controller;

import com.porfolio.api.Dao.SkillInterfaceDao;
import com.porfolio.api.Util.Models.Skill;
import com.porfolio.api.Util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SkillController {

    @Autowired
    private SkillInterfaceDao skillInterfaceDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/skill", method = RequestMethod.GET)
    public List<Skill> getAllSkill() { return skillInterfaceDao.getSkills(); }

    @RequestMapping(value = "api/skill/{id}", method = RequestMethod.GET)
    public Skill getSkill(@RequestHeader(value="x-token") String x_token, @PathVariable Long id) {

        if(jwtUtil.getKey(x_token) == null) { return  null; }
        return skillInterfaceDao.getSkill(id);
    }


    @RequestMapping(value = "api/skill", method = RequestMethod.POST)
    public Skill newSkill(@RequestHeader(value="x-token") String x_token, @RequestBody Skill skill) {
        if(jwtUtil.getKey(x_token) == null) { return  null; }

        Skill skillDB = skillInterfaceDao.newSkill(skill);


        if(skillDB != null){
            return skillDB;
        }

        return null;
    }

    @RequestMapping(value = "api/skill/{id}", method = RequestMethod.DELETE)
    public List<String> deleteSkill(@RequestHeader(value="x-token") String x_token, @PathVariable Long id ) {
        if(jwtUtil.getKey(x_token) == null) { return  null; }

        String res;

        if(skillInterfaceDao.deleteSkill(id)){
            res = "ok";
        }else{
            res = "error";
        }
        return List.of(res);
    }

    @RequestMapping(value = "api/skill", method = RequestMethod.PUT)
    public List<String> editSkill(@RequestHeader(value="x-token") String x_token, @RequestBody Skill skill) {
        if(jwtUtil.getKey(x_token) == null) { return  null; }
        String res;

        if(skillInterfaceDao.updateSkill(skill)){
            res = "ok";
        }else {
            res = "error";
        }
        return List.of(res);
    }

}
