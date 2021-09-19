package instrumentation.test2;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-31
 **/
public class AgentMain {
    public static void agentmain(String agentArgs, Instrumentation inst)
            throws ClassNotFoundException, UnmodifiableClassException,
            InterruptedException {
        inst.addTransformer(new Transformer (), true);
        inst.retransformClasses(TransClass.class);
        System.out.println("Agent Main Done");
    }
}