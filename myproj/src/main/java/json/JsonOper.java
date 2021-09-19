package json;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-09-24
 **/
@Slf4j
public class JsonOper {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        JSONObject baseObj = new JSONObject();
        baseObj.put("age", null);

//        long age = baseObj.getLongValue("name");
        long age = baseObj.getLongValue("age");

        log.info("age:{}", age);
    }
}
