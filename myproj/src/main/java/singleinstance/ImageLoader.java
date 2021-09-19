package singleinstance;

/**
 * @description: 饿汉式，线程安全，调用效率高，但不能延迟加载
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-19
 **/
public class ImageLoader {
    private static ImageLoader instance = new ImageLoader();
    private ImageLoader() {
        System.out.println("ImageLoader()");
    }

    public static ImageLoader getInstance() {
        return instance;
    }
}
