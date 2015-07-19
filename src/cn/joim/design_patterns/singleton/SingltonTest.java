package cn.joim.design_patterns.singleton;

public class SingltonTest {

	/**
	 * 对于Singleton pattern，在实现上实在没有什么可再介绍的，只是想到了大家一直在用的lazy加载；
	 * 我写了两段单例类，LazySingleton和NormalSingleton,最初我使用调用方案I,果然，打印结果如我所想：
	 * <p>
	 * SingltonTest 始化
	 * <p>
	 * LazySingleton 类加载
	 * 
	 * <p>
	 * SingletonHolder类加载...
	 * <p>
	 * 构造lazy.
	 * 
	 * <p>
	 * NormalSingleton 类加载
	 * <p>
	 * 构造normal
	 * <p>
	 * 其实这样好像还体会不到lazy这个概念(因为我们这时候已经访问了SingletonHolder，所以它也会被加载)。
	 * 那么问题来了，这个lazy的提出究竟体现在哪里呢？怎么才能LazySingleton类加载而内部类不加载而感受到lazy呢？
	 * <p>
	 * 随后，我想到了JVM类加载的机制，查看了《Java性能优化权威指南》 3.2.3节所介绍的VM类加载有关的内容：
	 * 
	 * “vm类加载： HotSpot类加载负责解析常量池符号这个过程需要加载，链接，然后初始化 Java类和Java接口。
	 * 
	 * Java
	 * API的Class.forname()/ClassLoader.loadClass()反射API和JNI_FindClass都可以引发类加载。 ”
	 * 
	 * 随后，我分别使用forname和loadClass方法去触发类加载，这就出现了调用方案II,打印结果是：
	 * <p>
	 * SingltonTest 初始化
	 * <p>
	 * 构造normal
	 * <p>
	 * LazySingleton 类加载.既然加载了类，就应该 去加载 静态的变量，即mInstance 引用的构造函数也会被执行。so...
	 * */

	public static void main(String[] args) {
		// 调用方案I:
		// LazySingleton mLazySingleton;
		// mLazySingleton = LazySingleton.getInstance();
		// System.out.println();
		// NormalSingleton mNormalSingleton;
		// mNormalSingleton = NormalSingleton.getInstance();
		// System.out.println("--------------------------------");
		// 调用方案II:
		try {
			// 触发 LazySingleton类加载.
			Class.forName(LazySingleton.class.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Class.forName(NormalSingleton.class.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
