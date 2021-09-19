package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONTokener;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-09-11
 **/


@Slf4j
public class JsonToMapTest02 {
    public static void main(String[] args) {
//        test1();
//        test1_1();
//        test2();
//        test3();
//        test4();
////        test5();
//        test6();
//        test7();
//        test8();
        test9();
    }

    public static void test1() {
        String strArr = "[{\"0\":\"zhangsan\",\"3\":\"lisi\",\"2\":\"wangwu\",\"1\":\"maliu\"}," +
                "{\"00\":\"zhangsan\",\"33\":\"lisi\",\"11\":\"wangwu\",\"22\":\"maliu\"}]";

        //第一种方式
        List<Map<String, String>> listObjectFir = (List<Map<String, String>>) JSONArray.parse(strArr);
        System.out.println("利用JSONArray中的parse方法来解析json数组字符串");
        log.info("listObjectFir: {}", JSON.toJSONString(listObjectFir, true));
    }

    public static void test1_1() {
        String strArr = "[{\"0\":\"zhangsan\",\"3\":\"lisi\",\"2\":\"wangwu\",\"1\":\"maliu\"}," +
                "{\"00\":\"zhangsan\",\"33\":\"lisi\",\"11\":\"wangwu\",\"22\":\"maliu\"}]";

        //第一种方式
        List<LinkedHashMap<String, String>> listObjectFir = (List<LinkedHashMap<String, String>>) JSONArray.parse(strArr);
        System.out.println("利用JSONArray中的parse方法来解析json数组字符串");
        log.info("listObjectFir: {}", JSON.toJSONString(listObjectFir, true));
    }

    public static void test2() {
        String strArr = "[{\"0\":\"zhangsan\",\"3\":\"lisi\",\"2\":\"wangwu\",\"1\":\"maliu\"}," +
                "{\"00\":\"zhangsan\",\"33\":\"lisi\",\"11\":\"wangwu\",\"22\":\"maliu\"}]";
        // 第二种方式
        List<Map<String, String>> listObjectSec = JSONArray.parseObject(strArr, List.class);
        System.out.println("利用JSONArray中的parseObject方法并指定返回类型来解析json数组字符串");
        log.info("listObjectSec: {}", JSON.toJSONString(listObjectSec, true));
    }

    public static void test3() {
        String strArr = "[{\"0\":\"zhangsan\",\"3\":\"lisi\",\"2\":\"wangwu\",\"1\":\"maliu\"}," +
                "{\"00\":\"zhangsan\",\"33\":\"lisi\",\"11\":\"wangwu\",\"22\":\"maliu\"}]";

        //第三种方式
        JSONArray listObjectThir = JSONArray.parseArray(strArr);
        // 错误用法
//        JSONArray listObjectThir = JSONArray.parseArray(strArr, Feature.OrderedField);
        System.out.println("利用JSONArray中的parseArray方法来解析json数组字符串");
        log.info("listObjectThir: {}", JSON.toJSONString(listObjectThir, true));
    }

    public static void test4() {
        String strArr = "[{\"0\":\"zhangsan\",\"3\":\"lisi\",\"2\":\"wangwu\",\"1\":\"maliu\"}," +
                "{\"00\":\"zhangsan\",\"33\":\"lisi\",\"11\":\"wangwu\",\"22\":\"maliu\"}]";

        //第四种方式, 这种方式符合我的要求
//        List listObjectFour = JSONArray.parseArray(strArr,Map.class);
        List listObjectFour = JSONArray.parseArray(strArr, LinkedHashMap.class);
        System.out.println("利用JSONArray中的parseArray方法并指定返回类型来解析json数组字符串");
        log.info("listObjectFour: {}", JSON.toJSONString(listObjectFour, true));
    }

    public static void test5() {
        String strArr = "[{\"0\":\"zhangsan\",\"3\":\"lisi\",\"2\":\"wangwu\",\"1\":\"maliu\"}," +
                "{\"00\":\"zhangsan\",\"33\":\"lisi\",\"11\":\"wangwu\",\"22\":\"maliu\"}]";
        // 第五种方式
        JSONArray listObjectFifth = JSONObject.parseArray(strArr);
        System.out.println("利用JSONObject中的parseArray方法来解析json数组字符串");
        log.info("listObjectFour: {}", JSON.toJSONString(listObjectFifth, true));
    }

    public static void test6() {
        String strArr = "[{\"0\":\"zhangsan\",\"3\":\"lisi\",\"2\":\"wangwu\",\"1\":\"maliu\"}," +
                "{\"00\":\"zhangsan\",\"33\":\"lisi\",\"11\":\"wangwu\",\"22\":\"maliu\"}]";

        //第六种方式
//        List listObjectSix = JSONObject.parseArray(strArr,Map.class);
        List listObjectSix = JSONObject.parseArray(strArr, LinkedHashMap.class);
        System.out.println("利用JSONObject中的parseArray方法并指定返回类型来解析json数组字符串");
        log.info("listObjectSix: {}", JSON.toJSONString(listObjectSix, true));
    }

    public static void test7() {
        String strArr = "[{\"0\":\"zhangsan\",\"3\":\"lisi\",\"2\":\"wangwu\",\"1\":\"maliu\"}," +
                "{\"00\":\"zhangsan\",\"33\":\"lisi\",\"11\":\"wangwu\",\"22\":\"maliu\"}]";

        //第七种方式
        JSONArray listObjectSeven = JSON.parseArray(strArr);
        System.out.println("利用JSON中的parseArray方法来解析json数组字符串");
        log.info("listObjectSeven: {}", JSON.toJSONString(listObjectSeven, true));
    }

    public static void test8() {
        String strArr = "[{\"0\":\"zhangsan\",\"3\":\"lisi\",\"2\":\"wangwu\",\"1\":\"maliu\"}," +
                "{\"00\":\"zhangsan\",\"33\":\"lisi\",\"11\":\"wangwu\",\"22\":\"maliu\"}]";

        //第八种方式
//        List listObjectEigh = JSON.parseArray(strArr,Map.class);
        List listObjectEigh = JSON.parseArray(strArr, LinkedHashMap.class);
        System.out.println("利用JSON中的parseArray方法并指定返回类型来解析json数组字符串");
        log.info("listObjectEigh: {}", JSON.toJSONString(listObjectEigh, true));
    }


    public static void test9() {
        String strArr = "[{\"0\":\"zhangsan\",\"3\":\"lisi\",\"2\":\"wangwu\",\"1\":\"maliu\"}," +
                "{\"00\":\"zhangsan\",\"33\":\"lisi\",\"11\":\"wangwu\",\"22\":\"maliu\"}]";

        //第9种方式
        String jsonStr = "...."; //json字符串
        Object json = new JSONTokener(strArr).nextValue();
        if(json instanceof JSONObject){
            JSONObject jsonObject = (JSONObject)json;
            log.info("jsonObject: {}", JSON.toJSONString(jsonObject, true));
        }else if (json instanceof JSONArray){
            JSONArray jsonArray = (JSONArray)json;
            log.info("jsonArray: {}", JSON.toJSONString(jsonArray, true));

        }
//
//        log.info("listObjectEigh: {}", JSON.toJSONString(listObjectEigh, true));
    }

}