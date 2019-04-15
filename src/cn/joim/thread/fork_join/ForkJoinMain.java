package cn.joim.thread.fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class ForkJoinMain {

	private static final ForkJoinPool sPool = ForkJoinPool.commonPool();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long low = 0, high = 100000;

		ItemTask task = new ItemTask(low, high);
		long start = System.currentTimeMillis();
		long result = sPool.invoke(task);
		long end = System.currentTimeMillis();
		long cost1 = end - start;
		System.out.println("with fork/join, cost: " + cost1 + " ms; result  = " + result);

		start = System.currentTimeMillis();
		result = LongStream.rangeClosed(low, high).parallel().sum();
		end = System.currentTimeMillis();
		long cost2 = end - start;
		System.out.println(
				"with normal add, cost: " + cost2 + " ms; result  = " + result + ", 耗费比例 ： " + (cost2 / cost1));

	}

}
