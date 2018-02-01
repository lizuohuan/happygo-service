package com.magicbeans.happygo.service.impl;

import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.entity.Comment;
import com.magicbeans.happygo.mapper.CommentMapper;
import com.magicbeans.happygo.service.ICommentService;
import com.magicbeans.happygo.vo.CommentVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Eric Xie on 2018/2/1 0001.
 */
@Service
public class CommentServiceImpl  extends BaseServiceImp<CommentMapper, Comment> implements ICommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<CommentVO> getCommentByProduct(String productId, Integer pageNO, Integer pageSize) {
        return commentMapper.queryCommentByProduct(productId,(pageNO - 1) * pageSize,pageSize);
    }

    @Override
    public Map<String, Object> countProductComment(String productId) {
        return commentMapper.countProductComment(productId);
    }


}
