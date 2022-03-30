package com.porfolio.api.Controller;


import com.porfolio.api.Dao.UserInterfaceDao;
import com.porfolio.api.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserInterfaceDao userInterfaceDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public User login(@RequestBody User user) {

        User userLogin = userInterfaceDao.getUserMail(user);
        return userLogin;
        /*
        if (userLogin != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(userLogin.getId()), userLogin.getMail());
            return List.of(tokenJwt);
        }
        return null;
        */
    }
}
