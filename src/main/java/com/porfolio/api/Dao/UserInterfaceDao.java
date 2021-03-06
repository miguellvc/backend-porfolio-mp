package com.porfolio.api.Dao;
import com.porfolio.api.Util.Models.User;

import java.util.List;

public interface UserInterfaceDao {

    List<User> getUser();
    void newUser(User user);
    void deleteUser(Long id);
    User getUserMail(User user);
}
