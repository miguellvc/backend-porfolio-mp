package com.porfolio.api.Controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @RequestMapping(value = "api/project", method = RequestMethod.GET)
    public List<String> getAllProject() {

        return List.of("Método mostrar all project");
    }

    @RequestMapping(value = "api/project/{id}", method = RequestMethod.GET)
    public List<String> getProject(@PathVariable Long id) {

        return List.of("Método get project", String.valueOf(id));
    }


    @RequestMapping(value = "api/project", method = RequestMethod.POST)
    public List<String> newProject() {

        return List.of("Método añadir un project");
    }

    @RequestMapping(value = "api/project", method = RequestMethod.PUT)
    public List<String> editProject() {
        return List.of("Método para modificar project");
    }

    @RequestMapping(value = "api/project", method = RequestMethod.DELETE)
    public List<String> deleteProject() {
        return List.of("Método para eliminar project");
    }

}
