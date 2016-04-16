package cn.joim.design_patterns.prototype;

import java.util.concurrent.*;

public class PrototypeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		JoimDoc mDoc = new JoimDoc();
		mDoc.setTitle("origin title.")
				.addImage("origin's first image.")
				.addImage("origin's second image.")
				.showDoc();

		JoimDoc mCopyDoc = (JoimDoc) mDoc.clone();
		mCopyDoc.showDoc();

		mCopyDoc.setTitle("copy title")
				.addImage("copy's first image");

		mDoc.showDoc();
		mCopyDoc.showDoc();

		JoimDoc mCopyDoc2 = null;
		ExecutorService pool = Executors.newFixedThreadPool(2);

		CountDownLatch latch = new CountDownLatch(3);

		Callable copyTask = new Callable() {
			@Override
			public Object call() throws Exception {
				JoimDoc copy = (JoimDoc) mDoc.clone();
				latch.countDown();
				return copy;
			}
		};

		Callable addOddImages = new Callable() {
			@Override
			public Object call() throws Exception {
				for(int i = 1; i < 1000;i += 2){
					mDoc.addImage("Image No.: " + Integer.toString(i));
				}
				latch.countDown();
				return null;
			}
		};

		Callable addEvenImage = new Callable() {
			@Override
			public Object call() throws Exception {
				for(int i = 2; i < 1000; i +=2){
					mDoc.addImage("Image No.: " + Integer.toString(i));
				}
				latch.countDown();
				return null;
			}
		};

		pool.submit(addOddImages);
		Future f1 = pool.submit(copyTask);
		pool.submit(addEvenImage);


		mCopyDoc2 = (JoimDoc) f1.get();
		pool.shutdown();

		latch.await();
		// mCopyDoc2's images is the screenshot of what origin doc is, when copy operation is taking place;
		mCopyDoc2.showDoc();

	}

}
