package net.jiguo.service.impl;

import net.jiguo.mapper.IndexMapper;
import net.jiguo.model.JgTryItem;
import net.jiguo.service.IndexServiceI;
import net.jiguo.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        Date date = new Date();
        for (JgTryItem item: hotUses) {
            //将活动开始时间，和结束时间转换成字符串
            String begin = DateTimeUtil.dateToString(date);
            String end = DateTimeUtil.dateToString(item.getEndDate());
            int days = 0;
            try {
                //计算出活动相差的天数
                 days = DateTimeUtil.getDayLength(begin, end);
            } catch (Exception e) {
                e.printStackTrace();
            }
            item.setDays(days);
        }
        return hotUses;
    }
}
