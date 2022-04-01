package com.porfolio.api.Controller;


import com.porfolio.api.Models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BannerController {

    @RequestMapping(value = "api/banner", method = RequestMethod.GET)
    public List<String> getBanner() {

        return List.of("Método get banner");
    }

    @RequestMapping(value = "api/banner", method = RequestMethod.POST)
    public List<String> newBanner() {

        return List.of("Método añadir un banner");
    }

    @RequestMapping(value = "api/banner", method = RequestMethod.PUT)
    public List<String> editBanner() {
        return List.of("Método para modificar banner");
    }

    @RequestMapping(value = "api/banner", method = RequestMethod.DELETE)
    public List<String> deleteBanner() {
        return List.of("Método para eliminar banner");
    }

}
