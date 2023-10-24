package pers.jyzh.springframework.core;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/23 15:03
 **/
public class TijResolvableType {

  private ArrayList<Map<String, ClassA<Integer, ? extends String, ? super BigDecimal>>>[] F;

  public static void main(String[] args) throws Exception {
    // 实例化：提供了工厂方法：ResolvableType.forXXX()
    newInstance();

    Field field = ReflectionUtils.findField(TijResolvableType.class, "F");
    Assert.notNull(field, "field");
    ResolvableType rt = ResolvableType.forField(field); // [Ljava.util.ArrayList;
    ResolvableType rt1 = rt.getComponentType(); // ArrayList
    ResolvableType rt2 = rt.getSuperType(); // java.util.ArrayList
    ResolvableType rt3 = rt1.getGeneric(0, 1, 2); // java.math.BigDecimal
    Object source = rt.getSource();
    Class<?> clazz = rt.resolve();
    if (clazz != null) {
      System.out.println(clazz.getSimpleName());
    }
  }

  private static void newInstance() throws Exception {
    // Type -> ResolvableType
    ResolvableType rt11 = ResolvableType.forType(ClassA.class);
    ResolvableType rt12 = ResolvableType.forType(ClassA.class, null);
    ResolvableType rt13 = ResolvableType.forType(new ParameterizedTypeReference<List<String>>() {
    });

    // Class -> ResolvableType
    ResolvableType rt21 = ResolvableType.forClass(ClassA.class);
    ResolvableType rt22 = ResolvableType.forClass(ClassA.class, ClassA.class);
    ResolvableType rt23 = ResolvableType.forRawClass(ClassA.class);
    ResolvableType rt24 = ResolvableType.forClassWithGenerics(ClassA.class, Integer.class,
        String.class, ClassA.class);
    ResolvableType rt25 = ResolvableType.forClassWithGenerics(ClassA.class,
        ResolvableType.forClass(Integer.class), ResolvableType.forClass(String.class), rt21);

    // ResolvableType -> ResolvableType
    ResolvableType rt31 = ResolvableType.forArrayComponent(rt23);

    // java.lang.reflect.Member -> ResolvableType
    Method[] methods = ClassA.class.getDeclaredMethods();
    ResolvableType rt41 = ResolvableType.forMethodParameter(new MethodParameter(methods[0], -1));
    // Constructor -> ResolvableType
    Constructor<?>[] constructors = ClassA.class.getDeclaredConstructors();
    ResolvableType rt42 = ResolvableType.forConstructorParameter(constructors[1], 0);
    ResolvableType rt43 = ResolvableType.forConstructorParameter(constructors[1], 0, Integer.class);
    // Field -> ResolvableType
    Field[] fields = ClassA.class.getDeclaredFields();
    ResolvableType rt44 = ResolvableType.forField(fields[0]);
    // Method -> ResolvableType
    ResolvableType rt45 = ResolvableType.forMethodParameter(methods[0], -1);
    ResolvableType rt46 = ResolvableType.forMethodReturnType(methods[0]);

    // Object -> ResolvableType
    ResolvableType rt51 = ResolvableType.forInstance("ResolvableType");
    System.out.println();
  }

  @Getter
  @Setter
  public static class ClassA<T extends Number & Serializable, M extends String, N>
      implements Serializable {
    private T f1;
    private M f2;
    private N f3;

    public ClassA() {

    }

    public ClassA(T f1) {
      this.f1 = f1;
    }
  }
}
