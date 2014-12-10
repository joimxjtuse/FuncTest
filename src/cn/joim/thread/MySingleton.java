package cn.joim.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class MySingleton {

	private Integer iParams;
	private static MySingleton instance;

	private MySingleton() {
		iParams = 100;
	}

	public static MySingleton getInstance() {
		if (null == instance) {
			synchronized (MySingleton.class) {
				if (null == instance) {
					instance = new MySingleton();
				}
			}
		}
		return instance;
	}

	public void addJustOneDelay(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//unlock or lock the add oper, we will get different result.
//		synchronized (iParams) {
			System.out.println("curThread:" + Thread.currentThread().getName()
					+ ";before:" + iParams);
			iParams++;
			System.out.println("curThread:" + Thread.currentThread().getName()
					+ ";after:" + iParams);
//		}
	}

	public int getParam() {

		return iParams;
	}

}
