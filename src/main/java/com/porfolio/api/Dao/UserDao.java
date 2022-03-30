package com.porfolio.api.Dao;


import com.porfolio.api.Models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDao implements UserInterfaceDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUser() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void newUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getUserMail(User user) {
        String query = "FROM User WHERE mail = :mail";
        List<User> list = entityManager.createQuery(query)
                .setParameter("mail", user.getMail())
                .getResultList();

        if (list.isEmpty()) {
            return null;
        }

        String passwordBD = list.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordBD, user.getPassword())) {
            return list.get(0);
        }
        return null;
    }

}
