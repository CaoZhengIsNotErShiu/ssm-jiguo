package net.jiguo.service;

import net.jiguo.model.JgTryReport;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/20 下午1:41
 * @Version 1.0
 */
public interface ReportServiceI {

    List<JgTryReport> getReportSelected(String user);

    /**
     * 点赞功能
     * @param user
     * @param reportId
     * @return
     */
    int getReportThumbByUserId(String user, String reportId);
}
