package com.porfolio.api.Controller;


import com.porfolio.api.Dao.UserInterfaceDao;
import com.porfolio.api.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserInterfaceDao userInterfaceDao;

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getUsers() {

        return userInterfaceDao.getUser();
    }

}
