package pers.jyzh.springframework.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZhengYu
 * @version 1.0 2023/11/5 14:51
 **/
public class TijPostProcessor {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(TijPostProcessor.class);
    ctx.addBeanFactoryPostProcessor(CustomBeanFactoryPostProcessor.INSTANCE);
    ctx.getBeanFactory().addBeanPostProcessor(CustomBeanPostProcessor.INSTANCE);
    ctx.refresh();
    ctx.close();
  }

  public static class CustomBeanFactoryPostProcessor
      implements BeanDefinitionRegistryPostProcessor, BeanFactoryPostProcessor {
    public static CustomBeanFactoryPostProcessor INSTANCE = new CustomBeanFactoryPostProcessor();

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
        throws BeansException {
      System.out.println("CustomBeanFactoryPostProcessor#postProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
        throws BeansException {
      System.out.println("CustomBeanFactoryPostProcessor#postProcessBeanDefinitionRegistry");
    }
  }

  public static class CustomBeanPostProcessor implements BeanPostProcessor {
    public static CustomBeanPostProcessor INSTANCE = new CustomBeanPostProcessor();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
        throws BeansException {
      System.out.println("CustomBeanPostProcessor#postProcessBeforeInitialization");
      return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
        throws BeansException {
      System.out.println("CustomBeanPostProcessor#postProcessAfterInitialization");
      return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
  }
}
