import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @description: tcp client2
 * @author: LiYuan liyuan@agree.com.cn
 * @version: 1.0
 * @ create: 2019-02-07 19:12
 **/
public class Client2 {
    public static void main(String[] args) {
        try {
            // 1.创建客户端socket，指定服务器地址和端口
            Socket socket = new Socket("localhost", 8888);
            // 2.获取输出流，向服务器发送信息
            // 字节输出流
            OutputStream os = socket.getOutputStream();
            //将输出流包装为打印流
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名: whf; 密码: 789");
            pw.flush();
            socket.shutdownOutput();
            // 3.获取输入流，并读取服务器的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while((info = br.readLine()) != null) {
                System.out.println("我是客户端，服务器说: " + info);
            }
            // 4.关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
