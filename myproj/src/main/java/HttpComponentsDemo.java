import org.apache.commons.io.IOUtils;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: HttpComponentsDemo
 * @author: LiYuan liyuan@agree.com.cn
 * @version: 1.0
 * @ create: 2019-02-05 21:53
 **/
public class HttpComponentsDemo {
    final static CloseableHttpClient client = HttpClients.createDefault();

    private String sendPostForm(String url, Map<String, String> params) throws Exception {
        HttpPost request = new HttpPost(url);
        // set header
        request.setHeader("X-Http-Demo", HttpComponentsDemo.class.getSimpleName());
        if (params != null) {
            List<BasicNameValuePair> nameValuePairList = new ArrayList();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nameValuePairList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            UrlEncodedFormEntity bodyEntity = new UrlEncodedFormEntity(nameValuePairList, "UTF-8");
            System.out.println("body:" + IOUtils.toString(bodyEntity.getContent()));
            request.setEntity(new UrlEncodedFormEntity(nameValuePairList));

        }

        CloseableHttpResponse response = client.execute(request);
        System.out.println("rsp code:" + response.getStatusLine().getStatusCode());
        // return content
        String ret = readResponseContent(response.getEntity().getContent());
        response.close();
        return ret;
    }

    private String sendGet(String url) throws Exception {
        return Request.Get(url).connectTimeout(1000).socketTimeout(1000).execute().returnContent().asString();
    }

    private String readResponseContent(InputStream inputStream) throws Exception {
        if (inputStream == null) {
            return "";
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[512];
        int len;
        while (inputStream.available() > 0) {
            len = inputStream.read(buf);
            out.write(buf, 0 ,len);
        }
        return out.toString();
    }


    public static void main(String []argv) throws Exception {
        System.out.println("class name: " + HttpComponentsDemo.class.getName());
        System.out.println("class simple name: " + HttpComponentsDemo.class.getSimpleName());

        HttpComponentsDemo httpUrlConnectionDemo = new HttpComponentsDemo();
        String url = "http://www.baidu.com";
        Map<String, String> params = new HashMap<String, String>();
        params.put("foo", "bar中文");
    //    String rsp = httpUrlConnectionDemo.sendPostForm(url, params);
    //    System.out.println("http post rsp: " + rsp);
        url = "http://www.baidu.com";
        System.out.println("http get rsp:" + httpUrlConnectionDemo.sendGet(url));
    }

}
