package cn.joim.jdk8.class_loader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

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

    private String byteCodePath;

    public JoimClassLoader(String byteCodePath) {

        super();
        this.byteCodePath = byteCodePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] value = null;
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(byteCodePath + name + ".class"));
            value = new byte[in.available()];
            in.read(value);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (in != null) {

                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        //TODO 可能在定义类之前，需要对字节码文件进行解密操作.
        return defineClass(null, value, 0, value.length, null);
    }

}
