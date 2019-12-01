package cn.joim.apt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * 在annotation模块编写一个运行时注解@Test:
 * 该注解会生成一个指定格式的类,先看看该注解的定义:
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface Test {

    String value();

}
