package cn.joim.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 查看反射代码的编译后实现(目录即reflect/)：
 * 1. 使用javac编译出class文件；
 * # javac HowImplReflect.java
 * 2. 使用javap反编译class文件：
 * # javap -c -s -v -l HowImplReflect.class
 *
 *
 * */
public class HowImplReflect {

    public static void main(String[] args) {
        String s = null;
        try {
            Class className = Class.forName("cn.joim.reflect.hide_class.UnkownPerson");
            //Constructor c = className.getConstructors();
            Constructor<?> cons = className.getConstructor(String.class, int.class);
            Object unKownPerson = cons.newInstance("joim", 31);
            Method[] method = unKownPerson.getClass().getMethods();
            System.out.print(unKownPerson);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
