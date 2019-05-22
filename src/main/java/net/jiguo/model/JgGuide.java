package net.jiguo.model;

import lombok.Data;

import java.sql.Date;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/21 下午4:46
 * @Version 1.0
 */
@Data
public class JgGuide {

    private int id;
    private String title;
    private String image;
    private Date issueDate;

}
