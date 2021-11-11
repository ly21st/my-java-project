package time;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @description: apache time
 * @author: LiYuan liyuan@agree.com.cn
 * @version: 1.0
 * @ create: 2019-04-15 17:15
 **/
public class ApacheTime {
    private final static Logger logger = LoggerFactory.getLogger(ApacheTime.class);

    private final static Logger logger2 = LoggerFactory.getLogger("second");

    public static void main(String[] args) {
        ApacheTime a = new ApacheTime();
        //   a.testDateFormatUtils();
        a.testDateFormat2();
//        a.testDataFormat3();
    }

    public void testDateFormatUtils() {
        String dateStr = DateFormatUtils.format(new Date(), "yyyy.M.d");
        logger.info("dateStr:" + dateStr);
    }


    public void testDateFormat2() {
        String dateStr = "2019.01.08";
//        String dateStr = "2019-01-08";
        DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("yyyy.M.d");
        LocalDate historyDate = LocalDate.parse(dateStr, dateFormatter1);

        System.out.printf("historyDate:%s\n", historyDate.toString());

//        String dateStr2 = "";
//        DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("yyyy.MM.dd");
//        dateStr2 = historyDate.format(dateFormatter2);
//
//        logger.info("historyDate:{}", historyDate);
//        logger.info("dateStr2:{}", dateStr2);
//
//        logger2.info("dateStr2:{}", dateStr2);
    }

    public static Date strToDate(String strDate, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(strDate, pos);
    }

    public void testDataFormat3() {
//        String strDate = "2020-09-11";
        String strDate = "2020.09.11";
        String format = "yyyy-MM-dd";
        Date historyDate = strToDate(strDate, format);

        if (historyDate == null) {
            System.out.println("historyDate is null");
        } else {
            System.out.println("historyDate is not null");
        }

        System.out.printf("historyDate:%s\n", historyDate.toString());
    }
}

