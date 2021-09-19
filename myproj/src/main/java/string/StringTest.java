package string;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: string test
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-16
 **/
@Slf4j
public class StringTest {
    private static transient Logger logger = LoggerFactory.getLogger(StringTest.class);
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();

        testSplit();
    }

    public static void test1() {
        String[] str = {"hello world","good","idea"};
        String str2 = "hello,world2";

        logger.info("str:{}", str);
        logger.info("str:{}", Arrays.toString(str));
        logger.info("str£∫{}", JSON.toJSONString(str));
        logger.info("str2;{}",str2);
    }

    public static void test2() {
      String message = "[10:05:02.538][T][d1fa6c288e4811e9][8e876332b3ad405d9aa55d748dc568b4][10]Drug item close him character good action assume control focus stage statement.";

//        String message = "[10:16:12.372][T][5fe5c63a8e4a11e9][cdf0b3abbc9a4e7cb7ac2b3ceda63ae7][130ffgg4]Voice risk usually head parent when either authority red idea benefit power and several air senior heart.";

        try {
            String[] splits = message.split("]");
            System.out.println("splits:" + JSON.toJSONString(splits));

            String timestamp = StringUtils.mid(splits[0], 1, 12);
            System.out.println("timestamp:" + timestamp);

            String level = StringUtils.mid(splits[1], 1, 1);
            System.out.println("level:" + level);

            String traceId = StringUtils.mid(splits[2], 1, 16);
            System.out.println("traceId:" + traceId);

            String uuid = StringUtils.mid(splits[3], 1, 32);
            System.out.println("uuid:" + uuid);

            Integer seq = Integer.valueOf(StringUtils.mid(splits[4], 1, 12));
            System.out.println("seq:" + seq);


            System.out.println("hello:" + splits[10]);
        } catch (Exception e) {
            logger.error("Ω‚Œˆ ß∞‹:", e);
            throw e;
        }

    }

    public static void test3() {
        List<String> list = new ArrayList<>(8);
        list.add("elasticdump");
        list.add("hello");
        list.add("world");
        list.add("good");
        list.add("hahaha");

        String str = StringUtils.join(list.toArray()," \\\n");
        System.out.println(str);
    }

    public static void test4() {
        String s1 = "hello,world,my name is lilei";
        String s2 = s1;
        String s3 = s2.replace("hello", "haha");
        s3 = s3.replace("my", "your");
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);
        System.out.println("s3:" + s3);
    }


    public static void test5() {
        String[] arr = requiredModules();
        System.out.println("arr" + JSON.toJSONString(arr));
        System.out.println("arr.length:" + arr.length);
    }

    public static  String[] requiredModules() {
        return new String[0];
    }


    public static void testSplit() {
//        String v = "10.8.4.47:9200";
        String v = "10.8.4.47:9200:8972";
//        String v = "10.8.4.47";
        String[] ipAndPort = v.split(":");

        log.info("ipAndPort:{}", JSON.toJSONString(ipAndPort, true));
    }
}
