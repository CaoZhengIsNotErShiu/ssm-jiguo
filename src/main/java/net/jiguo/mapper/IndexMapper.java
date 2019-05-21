package net.jiguo.mapper;

import net.jiguo.model.JgTryItem;
import net.jiguo.model.JgTryReport;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/17 上午10:32
 * @Version 1.0
 */
public interface IndexMapper {

    //热门试用
    List<JgTryItem> getHotUse();

}
