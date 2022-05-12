package com.porfolio.api.Dao;

import com.porfolio.api.Util.Models.Banner;


import java.util.List;

public interface BannerInterfaceDao {

    List<Banner> getBanners();
    Banner getBanner(Long id);
    Banner newBanner(Banner banner);
    boolean deleteBaner(Long id);
    boolean updateBanner(Banner banner);
}
