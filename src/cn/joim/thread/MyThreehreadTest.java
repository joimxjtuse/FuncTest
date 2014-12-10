package cn.joim.thread;

public class MyThreehreadTest {

	public static void main(String[] args) {

		Thread mThread1 = new Thread(new Runnable() {

			@Override
			public void run() {

				MySingleton mInstance = MySingleton.getInstance();
				mInstance.addJustOneDelay(2);

			}
		}, "mThread1");
		Thread mThread2 = new Thread(new Runnable() {

			@Override
			public void run() {

				MySingleton mInstance = MySingleton.getInstance();
				mInstance.addJustOneDelay(2);

			}
		}, "mThread2");
		Thread mThread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				MySingleton mInstance = MySingleton.getInstance();
				mInstance.addJustOneDelay(2);

			}
		}, "mThread3");
		mThread1.start();
		mThread2.start();
		mThread3.start();

	}

}
