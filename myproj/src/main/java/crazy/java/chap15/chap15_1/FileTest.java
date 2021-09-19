package crazy.java.chap15.chap15_1;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-30
 **/
public class FileTest {
    public static void  main(String []args) throws  Exception{
        test1();
//        test2();
    }

    public static void test1() throws Exception {
        File file = new File(".");
        File fileParent = file.getParentFile();

        System.out.println("fileParent:{}" + fileParent.getName());

//        File file = new File(".");
//        System.out.println(file.getName());
//        System.out.println(file.getParent());
//        System.out.println(file.getAbsoluteFile().getParent());
//        File tmpFile = File.createTempFile("aaa",".txt",file);
//        tmpFile.deleteOnExit();

//        File newFile = new File(System.currentTimeMillis() + "");
//        System.out.println("newFile对象是否存在: " + newFile.exists());
//
//        newFile.createNewFile();
//        //创建一个目录，因为newFile已存在，所以创建失败
//        newFile.mkdir();   newFile.mkdirs();
//
//        String[] fileList = file.list();
//        System.out.println("====当前路径下所欲文件和路径如下=====");
//        for (String fileName : fileList) {
//            System.out.println(fileName);
//        }
//
//        File[] roots = File.listRoots();
//        System.out.println("====系统所有根路径如下====");
//        for (File root : roots) {
//            System.out.println(root);
//        }
    }

    public static void test2() {
        File file = new File(".");
        String[] nameList = file.list(new MyFilenameFilter());
        for (String name : nameList) {
            System.out.println(name);
        }
    }


}

class MyFilenameFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".java") || new File(name).isDirectory();
    }
}


