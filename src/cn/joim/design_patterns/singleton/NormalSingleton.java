package cn.joim.design_patterns.singleton;

public class NormalSingleton {
	static {
		System.out.println("NormalSingleton 类加载");
	}

	private static NormalSingleton mInstance = new NormalSingleton();

	private NormalSingleton() {
		System.out.println("构造normal ");
	}

	public static NormalSingleton getInstance() {
		return mInstance;
	}
}
