package net.jiguo.mapper;

import net.jiguo.model.JgTryReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/20 下午1:44
 * @Version 1.0
 */
public interface ReportMapper {

    List<JgTryReport> getReportSelected();

    int getReportThumb(int id);

    int getReportComment(int id);

    int getReportThumbByUserId(@Param("id") int id,@Param("user") String user);

    void insertReportThumb(@Param("user") String user,@Param("reportId") int reportId);

    void deleteReportThumb(@Param("user") String user,@Param("reportId") int reportId);
}
