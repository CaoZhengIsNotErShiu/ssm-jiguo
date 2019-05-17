package net.jiguo.model;

import lombok.Data;

import java.sql.Date;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/17 上午10:24
 * @Version 1.0
 */
@Data
public class JgTryItem {

    private int id;
    private String title;
    private String image;
    private int quantity;
    private String category;
    private Date beginDate;
    private Date endDate;
    private double price;
    private int days;

}
