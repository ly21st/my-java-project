package generic;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-03-02
 **/
@Slf4j
public class ArrayTest {
    public static void main(String []args) {
        List<Map<String, String>> list;
        Map<String, String> map = new HashMap<>();
        map.put("appPath", "appPath");
        map.put("appId", "appId");
        map.put("method", "method");

        list = Arrays.asList(map);
        log.info("list:{}", JSON.toJSONString(list, true));
    }

}
