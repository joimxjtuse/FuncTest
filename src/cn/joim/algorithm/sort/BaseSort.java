package cn.joim.algorithm.sort;

/**
 * 排序代码模板，无实际意义.
 * */
public class BaseSort {

	public static void sort(Comparable[] a) {

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
}
