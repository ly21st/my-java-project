import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: tcp server2
 * @author: LiYuan liyuan@agree.com.cn
 * @version: 1.0
 * @ create: 2019-02-07 21:53
 **/
public class Server2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            // 记录客户端的数量
            int count = 0;
            System.out.println("***服务器即将启动，等待客户端的连接***");
            // 循环监听等待客户端的连接
            while(true) {
                // 调用accept方法开始监听，等待客户端的连接
                socket = serverSocket.accept();
                // 创建一个新的线程
                ServerThread serverThread = new ServerThread(socket);
                // 启动线程
                serverThread.start();
                count++;
                System.out.println("客户端的数量: " + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
