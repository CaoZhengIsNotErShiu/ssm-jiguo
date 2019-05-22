package net.jiguo.service.impl;

import net.jiguo.mapper.GuideMapper;
import net.jiguo.model.VO.JgGuideVO;
import net.jiguo.service.GuideServiceI;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/21 下午5:33
 * @Version 1.0
 */
@Service("guideService")
public class GuideServiceImpl implements GuideServiceI {

    @Autowired
    private GuideMapper guideMapper;

    /**
     * 获取最新导购
     * @return
     */
    public List<JgGuideVO> getGuideNewest() {
        List<JgGuideVO> list =  guideMapper.getGuideNewest();
        if (CollectionUtils.isNotEmpty(list)){
            for (JgGuideVO guide : list) {
              int thumbs =  guideMapper.getGuideThumb(guide.getId());
              int comments =  guideMapper.getGuideComment(guide.getId());
              guide.setGuideThumb(thumbs);//点赞数
              guide.setGuideComment(comments);//评论数
            }
        }
        return list;
    }
}
