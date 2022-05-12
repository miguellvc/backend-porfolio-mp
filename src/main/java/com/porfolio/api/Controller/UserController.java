package com.porfolio.api.Controller;


import com.porfolio.api.Dao.UserInterfaceDao;
import com.porfolio.api.Util.Models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserInterfaceDao userInterfaceDao;

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getUsers() {

        return userInterfaceDao.getUser();
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void newUser(@RequestBody User user){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);
        userInterfaceDao.newUser(user);
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        //UsuarioDaoInterface.deleteUser(Long id);
        userInterfaceDao.deleteUser(id);
        return "Se ejecuta el método eliminar";
    }

}
