package com.magicbeans.happygo.service.impl;

import com.magicbeans.happygo.Tree;
import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.entity.Resource;
import com.magicbeans.happygo.mapper.ResourceMapper;
import com.magicbeans.happygo.service.IResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author magicbeans
 * @since 2017-08-30
 */
@Service
@Transactional
public class ResourceServiceImpl extends BaseServiceImp<ResourceMapper, Resource> implements IResourceService {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public Set<String> findMenuCodeByUserId(String id) {
        return mapper.findMenuCodeByUserId(id);
    }

    @Override
    public List<Resource> selectRoleResource(String roleId) {
        return mapper.selectRoleResource(roleId);
    }

    @Override
    public List<Resource> selectAll() {
        return findAll();
    }

    @Override
    public List<Tree> selectAdminMenu(String adminId) {
        List<Tree> resultTree = new ArrayList<>();
       List<Resource> list =  mapper.selectAdminMenu(adminId);

       for (Resource resource : list){
           if(StringUtils.isEmpty(resource.getParentId())){
            Tree rootTree = new Tree(resource.getId(),resource.getResName(),Tree.TREE_NODE_STATE_DEFAULT);
            rootTree.setData(resource.getUrl());
            Resource.initTree(list,rootTree);
            resultTree.add(rootTree);
           }
       }

        return resultTree;
    }
}
