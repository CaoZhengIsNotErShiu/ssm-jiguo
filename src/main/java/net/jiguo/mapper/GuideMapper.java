package net.jiguo.mapper;

import net.jiguo.model.VO.JgGuideVO;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/21 下午5:35
 * @Version 1.0
 */
public interface GuideMapper {
    List<JgGuideVO> getGuideNewest();

    int getGuideThumb(int id);//点赞数

    int getGuideComment(int id);//评论数
}
