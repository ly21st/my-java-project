import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @description: HttpUrlConnection例子
 * @author: LiYuan liyuan@agree.com.cn
 * @version: 1.0
 * @ create: 2019-02-05 17:29
 **/
public class HttpUrlConnectionDemo {
    public static void main(String[] agrv) throws Exception  {
        test1();
    }

    public static void test1() throws Exception {
        // String urlString = "http://www.baidu.com";
        String urlString = "http://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=2&tn=baiduhome_pg&wd=java&oq=%25E6%25BD%2598%25E7%2588%25B1%25E6%25B0%2591&rsv_pq=baad712000062fce&rsv_t=ed6bdTBLXsu%2BusLOh2kV%2FUooYftwJ1WGnC9RdoTbL46MDsWALeuRsOpCosFEzVx%2BwTJk&rqlang=cn&rsv_enter=0&rsv_jmp=slow";
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);

        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            System.out.println("rsp:" + sb.toString());
        } else {
            System.out.println("rsp code:" + conn.getResponseCode());
        }
    }
}
