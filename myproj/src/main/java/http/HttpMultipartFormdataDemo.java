package http;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-07-13
 **/

public class HttpMultipartFormdataDemo {
    public static void main(String[] args) throws IOException {
        String sTestsetFile=  "E:\\tmp\\analysis-engine.jar";
        String sURL="http://10.8.1.65:8082/api/v1/flink/flink76/jars/upload";

        File f = new File(sTestsetFile);
        InputStream inputStream = new FileInputStream(f);
        String filename = f.getName();
        // 调用文件上传函数
        uploadFile(sURL, inputStream, filename);
    }

    public static void uploadFile(String sURL, InputStream inputStream, String filename) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost(sURL);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody(
                "file",
                inputStream,
                ContentType.APPLICATION_OCTET_STREAM,
                filename
        );
        try {
            uploadFile.setConfig(RequestConfig.custom()
                    .setConnectTimeout(300000).setConnectionRequestTimeout(30000)
                    .setSocketTimeout(300000).build());
            HttpEntity multipart = builder.build();
            uploadFile.setEntity(multipart);
            CloseableHttpResponse response = httpClient.execute(uploadFile);
            HttpEntity responseEntity = response.getEntity();
            String sResponse = EntityUtils.toString(responseEntity, "UTF-8");
            System.out.println("Post 返回结果" + sResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
