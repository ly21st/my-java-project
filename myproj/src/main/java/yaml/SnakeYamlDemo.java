package yaml;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.util.List;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-07-16
 **/
@Slf4j
public class SnakeYamlDemo {

    @Test
    public void testLoad() {
//        String yamlStr = "key: hello yaml";
        String yamlStr = "- value1\n" +
                "- value2\n" +
                "- value3";
        Yaml yaml = new Yaml();
        Object ret = yaml.load(yamlStr);
        System.out.println(ret);
        System.out.println(ret.getClass().getSimpleName());
    }

    @Test
    public void testLoad2() throws Exception {
//        String fileName = "H:/java_project_study/myproj/src/main/java/yaml/test.yaml";
        String fileName = "H:/java_project_study/myproj/src/main/java/yaml/filebeat.yaml";
        Yaml yaml = new Yaml();
        Object ret = yaml.load(new FileReader(fileName));
        System.out.println(ret);
//        System.out.println(ret.getClass().getSimpleName());
//        log.info("object: {}", JSON.toJSONString(ret, true));

//        log.info("dump:\n{}", yaml.dump(ret));
//        log.info("dump:\n{}", yaml.dumpAsMap(ret));
//        log.info("dump:\n{}", yaml.dumpAs(ret, Tag.MAP, DumperOptions.FlowStyle.BLOCK));
        log.info("dump:\n{}", yaml.dumpAs(ret, null, DumperOptions.FlowStyle.BLOCK));

    }

    @Test
    public void testType() throws Exception {
        Yaml yaml = new Yaml();
     //   String fileName = "H:/java_project_study/myproj/src/main/java/yaml/test.yaml";
        List<String> ret = (List<String>)yaml.load(this.getClass().getClassLoader()
                .getResourceAsStream("test.yaml"));
        System.out.println(ret);
    }
}
