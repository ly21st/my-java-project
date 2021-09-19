package pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-06-12
 **/
public class NumertPattern {
    private static transient Logger logger = LoggerFactory.getLogger(NumertPattern.class);

    public static void main(String []args) {
//        String s = searchDate("heleo20190612");
//        String s2 = searchDate("heleo20190612wwwe");
//        System.out.println("s:" + s);
//        System.out.println("s2:" + s2);

        testDate();
        testhosts();

        testName();
    }

    public static  String searchDate(String source) {
        String timeDate;
        String regx = "(\\d{8})";
//        String regx = "\\d{8}";
        java.util.regex.Pattern p = Pattern.compile(regx);
        Matcher m = p.matcher(source);
        if (m.find()) {
            timeDate = m.group(0);
        } else {
            timeDate="error";
            System.out.println("error");
        }
        return timeDate;
    }


    public static void testDate() {
        String dateReg = "\\d{4}[.\\-][0-9]*[0-9][.\\-][0-9]*[0-9]";
//        String dateReg = "\\d{4}\\.[0-9]*[0-9]\\.[0-9]*[0-9]";

        Pattern datePattern = Pattern.compile(dateReg);

        Matcher m;
        String dateStr;
//        String index = "afa-log-0002-2019.06.19";
        String index = "afa-log-0002-2019-6-19";

        try {
            int indexLen = index.length();
            m = datePattern.matcher(index.substring(indexLen - 10));
            if (m.find()) {
                dateStr = m.group();
                logger.info("dateStr:" + dateStr);
            } else {
                logger.info("not found");
            }
        } catch (Exception e) {
            logger.error("catch date of index error.", e);
        }

    }


    public static void testhosts() {
//        String dateReg = "\\d{4}[.\\-][0-9]*[0-9][.\\-][0-9]*[0-9]";
//        String dateReg = "\\d{4}\\.[0-9]*[0-9]\\.[0-9]*[0-9]";
        String hostReg = "^.*(:\\d{4,})*$";

        Pattern datePattern = Pattern.compile(hostReg);

        Matcher m;
//        String hosts = "10.8.4.12:9200";
        String hosts = "10.8.4.72:920";
//        String hosts = "10.8.4.72:92000";


        try {
            m = datePattern.matcher(hosts);
            if (m.find()) {
                String str = m.group(0);
                logger.info("dateStr:" + str);
            } else {
                logger.info("not found");
            }
        } catch (Exception e) {
            logger.error("Exception.", e);
        }

    }


    public static void testName() {
//        String dateReg = "\\d{4}[.\\-][0-9]*[0-9][.\\-][0-9]*[0-9]";
//        String dateReg = "\\d{4}\\.[0-9]*[0-9]\\.[0-9]*[0-9]";
        String nameReg = "^bigdata-logkeeper-engine-.*-uber.jar$";
        Pattern datePattern = Pattern.compile(nameReg);

        Matcher m;
        String dateStr;
//        String index = "afa-log-0002-2019.06.19";
//        String index = "afa-log-0002-2019-6-19";
//        String index = "bigdata-logkeeper-engine-aa-uber.jar";
        String index = "cc-bigdata-logkeeper-engine-aa-uber.jar";

        try {
            m = datePattern.matcher(index);
            if (m.find()) {
                dateStr = m.group();
                logger.info("dateStr:" + dateStr);
            } else {
                logger.info("not found");
            }
        } catch (Exception e) {
            logger.error("catch date of index error.", e);
        }

    }

}
