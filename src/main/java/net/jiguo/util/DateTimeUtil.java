package net.jiguo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/17 下午5:12
 * @Version 1.0
 */
public class DateTimeUtil {

    public static final String DATE_FORMAT_NORMAL = "yyyy-MM-dd";

    //计算给开始日期 结束日期 的间隔天数 yyyy-MM-dd
    public static int getDayLength(String start_date,String end_date) throws Exception{
        Date fromDate = getStrToDate(start_date,DATE_FORMAT_NORMAL);  //开始日期
        Date toDate = getStrToDate(end_date,DATE_FORMAT_NORMAL); //结束日期
        long from = fromDate.getTime();

        long to = toDate.getTime();

        //一天等于多少毫秒：24*3600*1000
        int day = (int)((to-from)/(24*60*60*1000));
        return day;
    }

    public static Date getStrToDate(String date,String fomtter) throws Exception{
        DateFormat df = new SimpleDateFormat(fomtter);
        return df.parse(date);
    }

    //日期转字符串
    public static String dateToString(Date date) {
//        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NORMAL);
        System.out.println(sdf.format(date));
        return sdf.format(date);
//        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(date));
//        sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//        System.out.println(sdf.format(date));
    }

    //字符串转日期
    public static Date stringToDate() throws ParseException {
        String string = "2016-10-24 21:59:06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.parse(string));
        return sdf.parse(string);
    }

    public static void main(String[] args) throws Exception{
        int days=DateTimeUtil.getDayLength("2019-05-13","2019-05-18");
        System.out.println(days);
    }
}
