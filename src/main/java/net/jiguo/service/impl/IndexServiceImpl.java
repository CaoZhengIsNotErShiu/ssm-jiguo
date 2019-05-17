package net.jiguo.service.impl;

import net.jiguo.mapper.IndexMapper;
import net.jiguo.model.JgTryItem;
import net.jiguo.service.IndexServiceI;
import net.jiguo.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/17 上午10:23
 * @Version 1.0
 */
@Service("indexService")
public class IndexServiceImpl implements IndexServiceI {

    @Autowired
    private IndexMapper indexMapper;

    public List<JgTryItem> getHotUse() {
        List<JgTryItem> hotUses = indexMapper.getHotUse();
        for (JgTryItem item: hotUses) {
            String begin = DateTimeUtil.dateToString(item.getBeginDate());
            String end = DateTimeUtil.dateToString(item.getEndDate());
            int days = 0;
            try {
                 days = DateTimeUtil.getDayLength(begin, end);
            } catch (Exception e) {
                e.printStackTrace();
            }
            item.setDays(days);
        }
        return hotUses;
    }
}
