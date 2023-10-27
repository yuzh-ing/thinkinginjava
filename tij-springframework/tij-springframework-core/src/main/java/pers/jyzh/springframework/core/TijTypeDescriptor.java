package pers.jyzh.springframework.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.ResolvableType;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.util.Assert;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ZhengYu
 * @version 1.0 2023/10/22 22:23
 **/
public class TijTypeDescriptor {
  public static void main(String[] args) {
    // 初始化，不太推荐静态方法初始化，因为无法设置注解信息
    ResolvableType rt = ResolvableType.forClass(ClassA.class);
    TypeDescriptor td = new TypeDescriptor(rt, ClassA.class, ClassA.class.getAnnotations());
    Assert.isTrue(td.hasAnnotation(Ann2.class), "td.hasAnn-Ann2");
    Assert.isTrue(td.hasAnnotation(Ann1.class), "td.hasAnn-Ann1");
    System.out.println(td.getAnnotation(Ann1.class).value());
  }

  @Getter
  @Setter
  @Ann2
  public static class ClassA {
    private String f1;
  }

  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.ANNOTATION_TYPE)
  public @interface Ann1 {
    String value() default "ann1";
  }

  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @Ann1("ann2.ann1")
  public @interface Ann2 {
    String alias() default "ann2";
  }
}
