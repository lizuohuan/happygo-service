package com.magicbeans.happygo.service;

import com.magicbeans.base.BaseService;
import com.magicbeans.happygo.entity.Comment;
import com.magicbeans.happygo.entity.IncomeDetail;
import com.magicbeans.happygo.vo.CommentVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Eric Xie on 2018/2/1 0001.
 */
public interface ICommentService extends BaseService<Comment> {


    /**
     *  产讯产品的评论信息
     * @param productId 产品ID
     * @param pageNO 分页参数
     * @param pageSize 分页参数
     * @return Comment 集合
     */
    List<CommentVO> getCommentByProduct(String productId, Integer pageNO, Integer pageSize);


    /**
     * 统计商品的 总评论数  和 好评率
     * @param productId 产品ID
     * @return total：总评论数  goodRatio：好评率
     */
    Map<String,Object> countProductComment(String productId);

}
