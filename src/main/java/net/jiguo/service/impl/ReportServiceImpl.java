package net.jiguo.service.impl;

import net.jiguo.mapper.ReportMapper;
import net.jiguo.model.JgTryReport;
import net.jiguo.service.ReportServiceI;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/20 下午1:42
 * @Version 1.0
 */
@Service("reportService")
public class ReportServiceImpl implements ReportServiceI {

    private static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Autowired
    private ReportMapper reportMapper;

    /**
     * 精选报告
     * @return
     */
    public List<JgTryReport> getReportSelected(String user) {
        List<JgTryReport> reports = reportMapper.getReportSelected();
        //遍历出报告的点赞,评论数
        if (CollectionUtils.isNotEmpty(reports)) {
            if (StringUtils.isNotEmpty(user)){
                user = StringUtils.substringBefore(user, "-");
                for (int i = 0; i < reports.size(); i++) {
                    int thumbs = reportMapper.getReportThumb(reports.get(i).getId());
                    int comment = reportMapper.getReportComment(reports.get(i).getId());
                    int isThumb = reportMapper.getReportThumbByUserId(reports.get(i).getId(), user);
                    reports.get(i).setThumb(thumbs);//被点赞数
                    reports.get(i).setComment(comment);//被评论数
                    reports.get(i).setIsThumb(isThumb);//是否被点赞
                }
            }else{
                for (int i = 0; i < reports.size(); i++) {
                    int thumbs = reportMapper.getReportThumb(reports.get(i).getId());
                    int comment = reportMapper.getReportComment(reports.get(i).getId());
                    reports.get(i).setThumb(thumbs);
                    reports.get(i).setComment(comment);
                }
            }

        }
        return reports;
    }

    /**
     * 点赞功能
     * @param user 用户id
     * @param reportId 报告id
     * @return
     */
    public int getReportThumbByUserId(String user, String reportId) {
        user = StringUtils.substringBefore(user, "-");
        int i=Integer.parseInt(reportId);
        try {
            int isThumb = reportMapper.getReportThumbByUserId(i, user);
            if (isThumb == 0){//说明不存在，不存在就是没有点赞，咱就实现插入功能
                reportMapper.insertReportThumb(user, i);
            }else{//存在，说明需要删除
                reportMapper.deleteReportThumb(user,i);
            }

        } catch (Exception e) {
            logger.error("@@@ 点赞功能方法中，抛出了异常 err @@@",e);
        }
        int reportThumb = reportMapper.getReportThumb(i);
        return reportThumb;
    }


}
