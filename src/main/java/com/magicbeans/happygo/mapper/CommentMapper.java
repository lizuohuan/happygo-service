package com.magicbeans.happygo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.magicbeans.happygo.entity.Comment;
import com.magicbeans.happygo.vo.CommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Eric Xie on 2018/2/1 0001.
 */
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     *  产讯产品的评论信息
     * @param productId 产品ID
     * @param limit 分页参数
     * @param limitSize 分页参数
     * @return Comment 集合
     */
    List<CommentVO> queryCommentByProduct(@Param("productId") String productId, @Param("limit") Integer limit,
                                          @Param("limitSize") Integer limitSize);


    /**
     * 统计商品的 总评论数  和 好评率
     * @param productId 产品ID
     * @return total：总评论数  goodRatio：好评率
     */
    Map<String,Object> countProductComment(@Param("productId") String productId);

}
