package pers.jyzh.springframework.core;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.core.ResolvableType;
import org.springframework.util.ReflectionUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/23 15:03
 **/
public class TijResolvableType {

  private List<Map<String, ClassA<Integer, ? extends String, ? super BigDecimal>>>[] F;

  public static void main(String[] args) throws Exception {
    // 实例化：提供了工厂方法：ResolvableType.forXXX()
    newInstance();

    Field field = ReflectionUtils.findField(TijResolvableType.class, "F");
    System.out.println();
  }

  private static void newInstance() {
    // 取class的封装对象
    ResolvableType rt1 = ResolvableType.forClass(ClassA.class);
    ResolvableType rt2 = ResolvableType.forRawClass(ClassA.class);
  }

  @Getter
  @Setter
  public static class ClassA<T extends Number & Serializable, M extends String, N> {
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
