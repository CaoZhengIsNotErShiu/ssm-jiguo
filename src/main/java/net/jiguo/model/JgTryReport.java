package net.jiguo.model;

import lombok.Data;

import java.sql.Date;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/20 下午1:32
 * @Version 1.0
 */
@Data
public class JgTryReport {

    private int id;
    private String title;
    private String image;
    private int applyId;
    private Date pubDate;
    private String name;//作者名
    private int thumb;//点赞数
    private int comment;//评论
    private int isThumb;//是否被当前用户点赞

}
