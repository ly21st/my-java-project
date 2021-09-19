package instrumentation.test3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-08-21
 **/

public class ThreadLocalTest {
    private static transient Logger logger = LoggerFactory.getLogger(ThreadLocalTest.class);
    public static void  main(String []args) throws Exception {
        Field f = ThreadLocalTest.class.getDeclaredField("CONTEXT");
        f.setAccessible(true);

        ThreadLocal<MyClass> CONTEXT = (ThreadLocal<MyClass>)f.get(ThreadLocalTest.class);

    }
}

class MyClass {
    int age;
}

















