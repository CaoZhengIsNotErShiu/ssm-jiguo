package net.jiguo.service;

import net.jiguo.model.VO.JgGuideVO;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/21 下午5:33
 * @Version 1.0
 */
public interface GuideServiceI {
    List<JgGuideVO> getGuideNewest();
}
