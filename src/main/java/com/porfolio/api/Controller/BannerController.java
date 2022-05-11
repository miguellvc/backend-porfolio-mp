package com.porfolio.api.Controller;


import com.porfolio.api.Dao.BannerInterfaceDao;
import com.porfolio.api.Models.Banner;
import com.porfolio.api.Util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BannerController {

    @Autowired
    private BannerInterfaceDao BannerInterfaceDao;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/banner", method = RequestMethod.GET)
    public List<Banner> getBanners() {

        return BannerInterfaceDao.getBanners();
    }

    @RequestMapping(value = "api/banner/{id}", method = RequestMethod.GET)
    public Banner getBanner(@RequestHeader(value="x-token") String x_token, @PathVariable Long id) {

        if(jwtUtil.getKey(x_token) == null) { return  null; }

        return BannerInterfaceDao.getBanner(id);
    }

    @RequestMapping(value = "api/banner", method = RequestMethod.POST)
    public Banner newBanner(@RequestHeader(value="x-token") String x_token, @RequestBody Banner banner ) {
        if(jwtUtil.getKey(x_token) == null) { return  null; }

        Banner bannerDB = BannerInterfaceDao.newBanner(banner);

        if(bannerDB != null){
               return bannerDB;
        }
        return null;

    }

    @RequestMapping(value = "api/banner/{id}", method = RequestMethod.DELETE)
    public List<String> deleteBanner(@RequestHeader(value="x-token") String x_token, @PathVariable Long id) {

        if(jwtUtil.getKey(x_token) == null) { return  null; }
         String res;

         if(BannerInterfaceDao.deleteBaner(id)) {
             res = "ok";
         }else {
             res = "error";
         }
        return List.of(res);
    }

    @RequestMapping(value = "api/banner", method = RequestMethod.PUT)
    public List<String> updateBanner( @RequestHeader(value="x-token") String x_token, @RequestBody Banner banner ) {

       if(jwtUtil.getKey(x_token) == null) { return  null; }
       String res;

       if(BannerInterfaceDao.updateBanner(banner)){
           res = "ok";
       }else {
           res = "error";
       }
       return List.of(res);
    }


}
