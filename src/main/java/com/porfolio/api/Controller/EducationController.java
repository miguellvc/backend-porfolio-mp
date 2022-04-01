package com.porfolio.api.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class EducationController {


    @RequestMapping(value = "api/education", method = RequestMethod.GET)
    public List<String> getAllEducation() {

        return List.of("Método mostrar all Educación");
    }

    @RequestMapping(value = "api/education/{id}", method = RequestMethod.GET)
    public List<String> getEducation(@PathVariable Long id) {

        return List.of("Método get Educación", String.valueOf(id));
    }


    @RequestMapping(value = "api/education", method = RequestMethod.POST)
    public List<String> newEducación() {

        return List.of("Método añadir un educación");
    }

    @RequestMapping(value = "api/education", method = RequestMethod.PUT)
    public List<String> editEducación() {
        return List.of("Método para modificar educación");
    }

    @RequestMapping(value = "api/education", method = RequestMethod.DELETE)
    public List<String> deleteEducación() {
        return List.of("Método para eliminar educación");
    }

}
