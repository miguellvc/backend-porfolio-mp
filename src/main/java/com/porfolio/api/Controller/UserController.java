package com.porfolio.api.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "api/usuario", method = RequestMethod.GET)
    public String getUser() {

        return "Hola mundo" ;
    }

}
