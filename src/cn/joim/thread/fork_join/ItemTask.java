package cn.joim.thread.fork_join;

import java.util.concurrent.RecursiveTask;

class ItemTask extends RecursiveTask<Long> {

	private long start;
	private long end;

	private static final long THRESHOLD = 10000L; // 临界值

	public ItemTask(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long length = end - start;

		if (length <= THRESHOLD) {
			return calcSum(start, end);

		} else {
			long mid = (end + start) / 2;

			ItemTask left = new ItemTask(start, mid);
			left.fork();

			ItemTask right = new ItemTask(mid, end);
			right.fork();

			return left.join() + right.join();
		}
	}

	static long calcSum(long start, long end) {
		long sum = 0;
		for (long i = start; i <= end; i++) {
			sum += i;
		}
		return sum;
	}
}
