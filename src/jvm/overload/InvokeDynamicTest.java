package jvm.overload;

import java.lang.invoke.*;
import java.lang.reflect.Method;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @Author pierre
 * 18-3-9
 */
public class InvokeDynamicTest {
    public static void main(String[] args) {

    }

    public static void testMethod(String s) throws Throwable {
        System.out.println("hello String :" + s);
        INDY_BootstrapMethod().invokeExact("hello world");
    }

    public static CallSite BootstrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt) throws NoSuchMethodException, IllegalAccessException {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
    }

    private static MethodType MT_BootstrapMethod() {
        return MethodType.fromMethodDescriptorString("(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", null);
    }

    private static MethodHandle MH_BootstrapMethod() throws Throwable {
        return lookup().findStatic(InvokeDynamicTest.class, "BootstrapMethod", MT_BootstrapMethod());
    }

    private static MethodHandle INDY_BootstrapMethod() throws Throwable {
        CallSite cs = (CallSite) MH_BootstrapMethod().invokeWithArguments(lookup(), "testMethod");
        MethodType.fromMethodDescriptorString("(Ljava/Lang/String;)V", null);
        return cs.dynamicInvoker();
    }
}
