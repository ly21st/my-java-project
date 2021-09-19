package instrumentation.test1;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-30
 **/
public class Premain {
    public static void premain(String agentArgs, Instrumentation inst)
            throws ClassNotFoundException, UnmodifiableClassException {
        ClassDefinition def = new ClassDefinition(TransClass.class, Transformer
                .getBytesFromFile(Transformer.classNumberReturns2));
        inst.redefineClasses(new ClassDefinition[] { def });
        System.out.println("success");
    }
}