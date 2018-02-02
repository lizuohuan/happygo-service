package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.Pages;
import com.magicbeans.happygo.entity.Banner;
import com.magicbeans.happygo.mapper.BannerMapper;
import com.magicbeans.happygo.service.IBannerService;
import com.magicbeans.base.BaseServiceImp;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author null123
 * @since 2018-02-02
 */
@Service
public class BannerServiceImpl extends BaseServiceImp<BannerMapper, Banner> implements IBannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public Pages<Banner> list(Map<String, Object> map, Pages pages) {

        int count = bannerMapper.listCount(map);
        pages.setTotal(count);
        if (count > 0) {
            map.put("pages",pages);
            pages.setRecords(bannerMapper.list(map));
        }

        return pages;
    }
}
