package cn.joim.algorithm.sort;

/**
 * @date 2015-5-4 21:53
 * 
 * @description 插入排序(冒泡排序)
 * 
 *              对于长度为N的数组，如果数组最开始就有序，则仅仅遍历N-1次，比较N-1次，数组即有序； 如果数组最开始为倒叙，则需要遍历 1
 *              + 2 + ... + (N-1) = N(N-1)/2,同时比较 1 + 2 + ... + (N-1) =
 *              N(N-1)/2次，数组才有序。
 * 
 *              平均时间复杂度为O(N^2)。
 * 
 * 
 * */
public class InsertSort {

	public static void sort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void exch(Comparable[] a, int i, int j) {
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void show(Comparable[] a) {

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {

			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * { 9, 8, 7, 6, 20, 5, 4, 3, 2 }
	 * 
	 * 第一次遍历 { 8, 9, 7, 6, 20, 5, 4, 3, 2 }； 第二次遍历 { 7, 8, 9, 6, 20, 5, 4, 3, 2
	 * }； 第三次遍历 { 6, 7, 8, 9, 20, 5, 4, 3, 2 }； 第四次遍历 { 6, 7, 8, 9, 20, 5, 4, 3,
	 * 2 }； 第五次遍历 { 5, 6, 7, 8, 9, 20, 4, 3, 2 }； 第六次遍历 { 4, 5, 6, 7, 8, 9, 20,
	 * 3, 2 }； 第七次遍历 { 3, 4, 5, 6, 7, 8, 9, 20, 2 }； 第八次遍历 { 2, 3, 4, 5, 6, 7,
	 * 8, 9, 20 }；
	 * 
	 */
	public static void main(String[] args) {
		Integer a[] = { 9, 8, 7, 6, 20, 5, 4, 3, 2 };
		sort(a);
		System.out.println("is sorted:" + isSorted(a));
		show(a);

	}

}
