package cn.joim.algorithm.sort;

/**
 * @date 2015-5-4 21:26
 * 
 * @description 选择排序(Selection Sort):<br>
 *              首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置（如果第一个元素最小，则和自己交换位置）。
 *              再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。 <br>
 *              长度为N的数组，比较次数为：（N-1） + （N-2） + ... + 1 = N（N-1）/2，时间复杂度为O(N^2)。 <br>
 *              优点: <br>
 *              1. 运行时间和数组初始顺序无关； <br>
 *              2. 数据移动次数为N（与其他排序算法相比，移动次数最少）。
 * 
 * */
public class SelectionSort {

	public static void sort(Comparable[] a) {
		int i = 0;
		while (i < a.length - 1) {
			int minPos = i;
			for (int j = i + 1; j < a.length; j++) {
				if (!less(a[i], a[j])) {
					minPos = j;
				}
			}
			if (minPos != i) {
				exch(a, minPos, i);
			}
			i++;
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
	 * 对于数组{9, 8, 7, 6, 20, 5, 4, 3, 2}，排序过程如下:<br>
	 * 
	 * 第一次遍历: [1, 8]: {2, 8, 7, 6, 20, 5, 4, 3, 9}，比较次数8<br>
	 * 第二次遍历: [2, 8]: {2, 3, 7, 6, 20, 5, 4, 8, 9}，比较次数7<br>
	 * 第三次遍历: [3, 8]: {2, 3, 4, 6, 20, 5, 7, 8, 9}，比较次数6<br>
	 * 第四次遍历: [4, 8]: {2, 3, 4, 5, 20, 6, 7, 8, 9}，比较次数5<br>
	 * 第五次遍历: [5, 8]: {2, 3, 4, 5, 6, 20, 7, 8, 9}，比较次数4<br>
	 * 第六次遍历: [6, 8]: {2, 3, 4, 5, 6, 7, 20, 8, 9}，比较次数3<br>
	 * 第七次遍历: [7, 8]: {2, 3, 4, 5, 6, 7, 8, 20, 9}，比较次数2<br>
	 * 第八次遍历: [8, 8]: {2, 3, 4, 5, 6, 7, 8, 9, 20}，比较次数1
	 * 
	 * */
	public static void main(String[] args) {
		Integer a[] = { 9, 8, 7, 6, 20, 5, 4, 3, 2 };
		sort(a);
		System.out.println("is sorted:" + isSorted(a));
		show(a);

	}

}
