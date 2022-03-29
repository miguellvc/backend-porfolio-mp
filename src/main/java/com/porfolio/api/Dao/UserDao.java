package com.porfolio.api.Dao;


import com.porfolio.api.Models.User;
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
}
