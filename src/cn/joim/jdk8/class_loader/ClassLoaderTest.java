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

        /**
         * 双亲委派模型(Parents Delegation Model):
         * -除BootstrapClassLoader外，程序中的每一个类加载器都应该拥有一个超类加载器，那么一个类加载器接收到一个
         * 类加载任务时，并不会立即展开加载，而是将加载任务委托给它的超类加载器去执行，每一层的类加载器都采用相同的
         * 方式，直至委派给最顶层的启动类加载器为止。如果超类无法加载委派它的类时，便会将类的加载任务退回给它的下一级
         * 类加载器去执行加载。
         *
         * 优点：能有效的保证一个类的全局唯一性
         *
         * 步骤：
         * 1. 检查是否已加载过；
         * 2. 通过父类执行加载；
         * 3. 自行加载.
         *
         * 注：虚拟机规范并没有要求使用双亲委派机制去加载，只是建议。比如Tomcat中，其加载顺序是优先使用子类，才会去
         * 使用父类加载器。
         * */


        /**
         * 为什么需要自定义类加载器?
         * 1. 字节码文件在编译时做了加密处理，如果不先做揭秘是无法通过JVM提供的三种来解析的，需要自定义；
         * 2. AppClassLoader加载的是ClassPath目录中的类，如果一些类并没有在这个目录中，则需要自定义类加载器去处理。
         *
         *
         *
         *
         * */

    }
}
