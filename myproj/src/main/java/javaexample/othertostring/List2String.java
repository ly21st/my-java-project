package javaexample.othertostring;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-06-10
 **/
public class List2String {
    public static void main(String []args) {
        test1();
    }

    public static void test1() {
        List<String> list= new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("addr");
        list.add("school");
        String s = StringUtils.join(list.iterator(),",");
        System.out.println("list:" + s);
    }
}
