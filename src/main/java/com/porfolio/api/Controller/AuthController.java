package com.porfolio.api.Controller;


import com.porfolio.api.Dao.UserInterfaceDao;
import com.porfolio.api.Util.Models.User;
import com.porfolio.api.Util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private UserInterfaceDao userInterfaceDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public List<String> login(@RequestBody User user) {

        User userLogin = userInterfaceDao.getUserMail(user);

        if (userLogin != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(userLogin.getId()), userLogin.getName());
            return List.of(tokenJwt);
        }
        return null;
    }

    @RequestMapping(value = "api/token", method = RequestMethod.GET)

    public boolean verifyToken(@RequestHeader(value="x-token") String x_token) {

        try {
            return jwtUtil.getValue(x_token)!=null;
        }catch (Exception e) {
            return false;
        }

    }

}
