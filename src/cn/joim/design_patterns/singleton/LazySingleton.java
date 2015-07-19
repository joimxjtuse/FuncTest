package cn.joim.design_patterns.singleton;

public class LazySingleton {

	static {
		System.out.println("LazySingleton 类加载");
	}

	private LazySingleton() {
		System.out.println("构造lazy.");
	}

	public static LazySingleton getInstance() {
		return SingletonHolder.LAZY_SINGLETON;
	}

	private static class SingletonHolder {
		static {
			System.out.println("SingletonHolder类加载...");
		}
		private static final LazySingleton LAZY_SINGLETON = new LazySingleton();
	}

}
