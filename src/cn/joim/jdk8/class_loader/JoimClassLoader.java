package cn.joim.jdk8.class_loader;

public class JoimClassLoader extends ClassLoader {

    /***
     * getParent(): 返回该类加载器的超类加载器;
     *
     * loadClass(name): 加载名称为name的类,返回结果为java.lang.Class的实例;
     *
     * findClass(name): 查找名称为name的类,返回结果为java.lang.Class的实例;
     *
     * findLoadedClass(name): 查找名称为name的已经被加载的类,返回结果为java.lang.Class类的实例;
     *
     * defineClass(name, b, off, len): 把字节数组b中的内容转换为一个Java类,返回结果为java.lang.Class的实例;
     *
     * resolveClass(c): 连接指定的一个Java类.
     *
     * */


    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

}
