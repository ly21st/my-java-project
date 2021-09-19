package yaml;

import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileReader;
import java.util.Map;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-07-16
 **/
public class YamlDemo {
    public static void main(String[] args) throws Exception {
        test1();
    }

    public static void test1() throws Exception {
        String fileName = "H:\\java_project_study\\myproj\\src\\main\\java\\yaml\\contact.yml";
        YamlReader reader = new YamlReader(new FileReader(fileName));
        Object object = reader.read();
        System.out.println(object);
        Map map = (Map)object;
        System.out.println(map.get("address"));
    }
}
