package cn.joim.jdk8.class_loader;

import sun.text.resources.ar.CollationData_ar;

public class ClassLoaderTest {

    public static void main(String[] args) {


        /**
         * BootstrapClassLoader: 主要复杂加载JAVA_HOME/lib目录中的类型.
         *
         * */
        ClassLoader bootstrapLoader = System.class.getClassLoader();
        // 启动类加载器是由C++写嵌套在JVM内部，所以输出结果才会为null.
        System.out.println("loader info: " +
                bootstrapLoader != null ? bootstrapLoader.getClass().getName() : "null"
        );

        /**
         * ExtClassLoader: 负责加载JAVA_HOME/lib/ext 目录中的类型.
         *
         * */
        ClassLoader extClassLoader = CollationData_ar.class.getClassLoader();
        System.out.println("loader info: " +
                extClassLoader != null ? extClassLoader.getClass().getName() : "null"
        );

        /**
         * AppClassLoader: 负责加载ClassPath目录中的类型.
         *
         * */
        ClassLoader appClassLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println("loader info: " +
                appClassLoader != null ? appClassLoader.getClass().getName() : "null"
        );


        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        ClassLoader parentClassLoader = classLoader.getParent();
        System.out.println("current : " + classLoader.getClass().getName() + "; parent : " +
                parentClassLoader.getClass().getName());

    }
}
