package com.porfolio.api.Dao;

import com.porfolio.api.Models.Banner;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional

public class BannerDao implements BannerInterfaceDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Banner> getBanners() {
        String query = "FROM Banner";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Banner getBanner(Long id) {
      /*  String query = "FROM Banner WHERE id = :id";

        List<Banner> list = entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();

        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
        */
        Banner banner = entityManager.find(Banner.class, id);
        return banner;
    }

    @Override
    public Banner newBanner(Banner banner) {
        try{
            Banner bannerDB = entityManager.merge(banner);
            return bannerDB;
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean deleteBaner(Long id) {

        try{
            Banner banner = entityManager.find(Banner.class, id);
            entityManager.remove(banner);
            System.out.println("se ejecuta el método eliminar");
            return true;
        }catch (Exception e){
            System.out.println(e);
            System.out.println("se ejecuta el error");
            return false;
        }
    }


}


/*
*
*         entityManager.createNativeQuery("")
                .setParameter("id", id)
                .executeUpdate();
                * https://es.stackoverflow.com/questions/8470/despues-de-un-update-ejecuto-un-select-pero-los-datos-no-se-actualizan
*
* */