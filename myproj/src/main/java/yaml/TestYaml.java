package yaml;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-07-24
 **/

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

public class TestYaml {

    public static void main(String[] args) {

        readJsonAndCreateYaml("conf/param.json", "conf/patam123.yaml");

        yamlToJson("conf/file.yaml");

    }

    /**
     * 讀取json并生成yaml
     */
    public static void readJsonAndCreateYaml(String json_url, String yaml_url) {
        try {
            String param = readJson(json_url);
            createYaml(yaml_url, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 將json轉化為yaml格式并生成yaml文件
     *
     * @param jsonString
     * @return
     * @throws JsonProcessingException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public static void createYaml(String yaml_url, String jsonString) throws JsonProcessingException, IOException {
        // parse JSON
        JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonString);
        // save it as YAML
        String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonNodeTree);

        Yaml yaml = new Yaml();
        Map<String, Object> map = (Map<String, Object>) yaml.load(jsonAsYaml);

        createYamlFile(yaml_url, map);
    }

    /**
     * 将数据写入yaml文件
     *
     * @param url  yaml文件路径
     * @param data 需要写入的数据
     */
    public static void createYamlFile(String url, Map<String, Object> data) {
        Yaml yaml = new Yaml();
        FileWriter writer;
        try {
            writer = new FileWriter(url);
            yaml.dump(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 讀取json文件并返回字符串
     *
     * @param url
     * @return
     * @throws Exception
     */
    @SuppressWarnings("resource")
    public static String readJson(String url) throws Exception {
        File file = new File(url);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(fileReader);
        String message = new String();
        String line = null;
        while ((line = bufReader.readLine()) != null) {
            message += line;
        }
        return message;
    }

    /**
     * 方法一
     * <p>
     * 讀取yaml生成Map并返回
     *
     * @param file
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> yamlToMap(String yaml_url) {
        Map<String, Object> loaded = null;
        try {
            FileInputStream fis = new FileInputStream(yaml_url);
            Yaml yaml = new Yaml();
            loaded = (Map<String, Object>) yaml.load(fis);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return loaded;
    }

    /**
     * 方法二
     * <p>
     * 读取yaml的内容并转为map
     *
     * @param url
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Map returnMapFromYaml(String yaml_url) {
        YamlReader reader;
        Object object = null;
        Map map = null;
        try {
            reader = new YamlReader(new FileReader(yaml_url));
            object = reader.read();
            map = (Map) object;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (YamlException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 讀取yaml生成json并返回
     *
     * @param file
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String yamlToJson(String file) {
        Gson gs = new Gson();
        Map<String, Object> loaded = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            Yaml yaml = new Yaml();
            loaded = (Map<String, Object>) yaml.load(fis);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return gs.toJson(loaded);
    }


//  /**
//   * demo
//   * 生成yaml格式的string，并寫入yaml文件
//   */
//  public static void testDumpWriterforyaml() {
//      Map<String, Object> data = new HashMap<String, Object>();
//      data.put("name", "Silenthand Olleander");
//      data.put("race", "Human");
//      data.put("traits", new String[] { "ONE_HAND", "ONE_EYE" });
//
//      Yaml yaml = new Yaml();
//      FileWriter writer;
//      try {
//          writer = new FileWriter("conf/param123.yaml");
//          yaml.dump(data, writer);
//      } catch (IOException e) {
//          e.printStackTrace();
//      }
//  }
//
//  /**
//   * 打印生成yaml格式的string
//   */
//  public static void testDump() {
//      Map<String, Object> data = new HashMap<String, Object>();
//      data.put("name", "Silenthand Olleander");
//      data.put("race", "Human");
//      data.put("traits", new String[] { "ONE_HAND", "ONE_EYE" });
//      Yaml yaml = new Yaml();
//      String output = yaml.dump(data);
//      System.out.println(output);
//  }
//
//  /**
//   * 打印生成yaml格式的string
//   */
//  public static void printDumpWriter() {
//      Map<String, Object> data = new HashMap<String, Object>();
//      data.put("name", "Silenthand Olleander");
//      data.put("race", "Human");
//      data.put("traits", new String[] { "ONE_HAND", "ONE_EYE" });
//      Yaml yaml = new Yaml();
//      StringWriter writer = new StringWriter();
//      yaml.dump(data, writer);
//      System.out.println(writer.toString());
//  }
}
