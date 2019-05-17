import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/17 上午10:46
 * @Version 1.0
 */
public class DayTest {

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


    public static void main(String[] args) throws Exception{
        int days=DayTest.getDayLength("2019-05-13","2019-05-18");
        System.out.println(days);
    }



}
