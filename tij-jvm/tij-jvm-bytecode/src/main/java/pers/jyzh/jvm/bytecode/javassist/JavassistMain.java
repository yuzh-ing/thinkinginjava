package pers.jyzh.jvm.bytecode.javassist;

import javassist.*;

/**
 * @author ZhengYu
 * @version 1.0 2023/12/14 16:54
 **/
public class JavassistMain {
  public static void main(String[] args) throws Exception {
    ClassPool pool = ClassPool.getDefault();

    CtClass ctClass = pool
        .makeClass("pers.jyzh.jvm.bytecode.javassist.JavassistDynamicGenerateClass");

    CtField ctField = new CtField(CtClass.intType, "state", ctClass);
    ctField.setModifiers(Modifier.PRIVATE);
    ctClass.addField(ctField, "10");

    CtMethod ctMethod = CtNewMethod.make("public int add(int a, int b) { return a + b; }", ctClass);
    ctMethod.setBody("{ return $1 * $2 + state; }");
    ctClass.addMethod(ctMethod);

    Class<?> clazz = ctClass.toClass();
    Object obj = clazz.newInstance();
    Object result = clazz.getDeclaredMethod("add", int.class, int.class).invoke(obj, 2, 3);
    System.out.println(result);
    Class<?> clazz1 = JavassistMain.class.getClassLoader()
        .loadClass("pers.jyzh.jvm.bytecode.javassist.JavassistDynamicGenerateClass");
    System.out.println(clazz1);
  }
}
