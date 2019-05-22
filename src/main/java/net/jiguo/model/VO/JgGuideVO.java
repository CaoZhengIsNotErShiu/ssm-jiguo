package net.jiguo.model.VO;

import lombok.Data;
import net.jiguo.model.JgGuide;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/21 下午5:00
 * @Version 1.0
 */
@Data
public class JgGuideVO extends JgGuide {

    private int guideThumb;//点赞数
    private int guideComment;//评论数


}
