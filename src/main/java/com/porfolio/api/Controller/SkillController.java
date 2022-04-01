package com.porfolio.api.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class SkillController {

    @RequestMapping(value = "api/skill", method = RequestMethod.GET)
    public List<String> getAllSkill() {

        return List.of("Método mostrar all skill");
    }

    @RequestMapping(value = "api/skill/{id}", method = RequestMethod.GET)
    public List<String> getSkill(@PathVariable Long id) {

        return List.of("Método get skill", String.valueOf(id));
    }


    @RequestMapping(value = "api/skill", method = RequestMethod.POST)
    public List<String> newSkill() {

        return List.of("Método añadir un skill");
    }

    @RequestMapping(value = "api/skill", method = RequestMethod.PUT)
    public List<String> editSkill() {
        return List.of("Método para modificar skill");
    }

    @RequestMapping(value = "api/skill", method = RequestMethod.DELETE)
    public List<String> deleteSkill() {
        return List.of("Método para eliminar skill");
    }


}
