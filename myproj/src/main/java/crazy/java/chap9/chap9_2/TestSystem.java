package crazy.java.chap9.chap9_2;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-28
 **/
public class TestSystem {
    public static void main(String []args) throws Exception {
        Map<String, String> env = System.getenv();
//        for (String name : env.keySet()) {
//            System.out.println(name + " ------> " + env.get(name));
//        }

//        env.entrySet();
//        for (Map.Entry<String, String> entry : env.entrySet()) {
//            System.out.println(entry.getKey() + "------> " + entry.getValue());
//        }

        System.out.println(System.getenv("JAVA_HOME"));
        Properties props = System.getProperties();
        props.store(new FileOutputStream("props.txt"), "System Properties");
        System.out.println(System.getProperty("os.name"));

    }



}
