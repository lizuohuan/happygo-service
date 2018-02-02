package com.magicbeans.happygo.service;

import com.magicbeans.base.Pages;
import com.magicbeans.happygo.entity.Banner;
import com.magicbeans.base.BaseService;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  banner
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
public interface IBannerService extends BaseService<Banner> {

    /**
     * banner列表
     * @param map
     * @return
     */
    Pages<Banner> list(Map<String,Object> map, Pages pages);


}
