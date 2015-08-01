package cn.joim.algorithm;

import java.util.BitSet;

/**
 * 布隆过滤器：可以判断某个数据是否存在的数据结构。 特点： 1）判断时间与数据个数无关（O(1)）； 2）空间效率非常好； 3）无法删除元素；
 * 4）偶尔会出错~ 使用k个散列函数和m比特的比特数组。
 * 
 * 转自：http://blog.csdn.net/acceptedxukai/article/details/7031899
 * 
 * */
public class BloomFilter {

	// 布隆过滤器的比特长度
	private static final int DEFAULT_SIZE = 2 << 24;// m

	// 这里要选取质数，能很好的降低错误率
	private static final int[] seeds = { 3, 5, 7, 11, 13, 31, 37, 61 };// k

	private static BitSet bits = new BitSet(DEFAULT_SIZE); // m比特的比特数组.

	private static SimpleHash[] func = new SimpleHash[seeds.length];// k个散列函数.

	public static void main(String[] args) {
		String value = "joimxjtuse@gmail.com";
		for (int i = 0; i < seeds.length; i++) {
			func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
		}
		add(value);
		System.out.println(contains(value));
	}

	public static void addValue(String value) {
		for (SimpleHash f : func) {
			// 将字符串value哈希为8个或多个整数，然后在这些整数的bit上变为1
			bits.set(f.hash(value), true);
		}
	}

	public static void add(String value) {
		if (value != null) {
			addValue(value);
		}
	}

	public static boolean contains(String value) {
		if (value == null)
			return false;
		boolean ret = true;
		for (SimpleHash f : func)
			// 这里其实没必要全部跑完，只要一次ret==false那么就不包含这个字符串
			ret = ret && bits.get(f.hash(value));
		return ret;
	}

	static class SimpleHash {

		private int cap;
		private int seed;

		public SimpleHash(int cap, int seed) {
			this.cap = cap;
			this.seed = seed;
		}

		/**
		 * string to hash
		 * */
		public int hash(String value) {
			int result = 0;
			int len = value.length();
			for (int i = 0; i < len; i++) {
				result = seed * result + value.charAt(i);
			}
			return (cap - 1) & result;
		}

	}

}
