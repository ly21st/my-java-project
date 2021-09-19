package crazy.java.chap9.chap9_2;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-29
 **/
public class TestExec
{
    public static void main(String[] args)throws Exception
    {
        Runtime rt = Runtime.getRuntime();
        rt.exec("notepad.exe");
    }
}

