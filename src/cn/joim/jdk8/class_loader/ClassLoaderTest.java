package cn.joim.jdk8.class_loader;

public class ClassLoaderTest {

    public static void main(String[] args) {


        /**
         * BootstrapClassLoader: 主要复杂加载JAVA_HOME/lib目录中的类型.
         *
         * */
        ClassLoader bootstrapLoader = System.class.getClassLoader();
        // 启动类加载器是由C++写嵌套在JVM内部，所以输出结果才会为null.
        if (bootstrapLoader != null) {
            System.out.println("loader info: " + bootstrapLoader.getClass().getName());
        }
        /**
         * ExtClassLoader: 负责加载JAVA_HOME/lib/ext 目录中的类型.
         *
         * */
        //TODO 看来教材上提供的JAVA_HOME/lib/ext中的类已经在11上移除类.
//        ClassLoader extClassLoader = sun.text.resources.ar.CollationData_ar.class.getClassLoader();
//        System.out.println("loader info: " +
//                extClassLoader != null ? extClassLoader.getClass().getName() : "null"
//        );

        /**
         * AppClassLoader: 负责加载ClassPath目录中的类型.
         *
         * */
        ClassLoader appClassLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(appClassLoader != null ? appClassLoader.getClass().getName() : "null"
        );


        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        ClassLoader parentClassLoader = classLoader.getParent();
        System.out.println("current : " + classLoader.getClass().getName() + "; parent : " +
                parentClassLoader.getClass().getName());

    }
}
