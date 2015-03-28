package cn.joim.algorithm;

import java.util.Scanner;

public class LampAlgorithm {
	
	public static final int MAX_INT = 100;

	/**
	 * 有n盏台灯，编号为1~n，全是关闭的。 
	 * 第一个人，将所有台灯打开；
	 * 第二个人，按下所有编号是2的倍数的台灯的开关（这些灯将被关掉）；
	 * 第三个人，按下所有编号是3的倍数的台灯的开关（其中，关着的灯将被打开，开着的灯将被关闭）；
	 *  ……
	 *  依此类推。
	 * 一共有k个人，最后有哪些灯开着？
	 * 输入n和k，输出开着的灯的编号。 k<=n<=100
	 * 
	 * 样例输入：
	 * 7 3
	 * 样例输出：
	 * 1 5 6 7
	 * 
	 * 分析：
	 * 如果 n = k时， 
	 * 2被第1、2个人按了；                       偶数
	 * 3被第1、3个人按了；                       偶数
	 * 4第1、2、4个人按了；                     奇数
	 * 5被第、1、5个人按了；                   偶数
	 * 6 =  1、2、3、6；                      偶数
	 * 7 = 1、7；                                   偶数
	 * 8 = 1、2、4、8；                        偶数
	 * 9 = 1、3、9；                             奇数
	 * ....
	 * 16 = 1、2、4、8、16                 奇数
	 * 32 = 1、2、4、8、16、21         偶数
	 * */
	public static void main(String[] args) {
		int n = 0,k = 0;
		int arr[];
		Scanner mScan = new Scanner(System.in);
		if(mScan.hasNext()){
			n = mScan.nextInt();
			k = mScan.nextInt();
		}
		n = MAX_INT > n ? n : MAX_INT; //n盏灯。
		k = MAX_INT > k ? k : MAX_INT; //k个人。
		arr =new int [n + 1];
		for (int person = 1; person <= k; person++) {
			if (person <= n) {
				for (int i = 1; i * person <= n; i++) {
					arr[i * person] = (arr[i * person] + 1) % 2;
				}
			}
		}
		for(int i = 1 ;i <= n;i++){
			if(arr[i]!=0){
				System.out.print(i);
				System.out.print(" ");
			}
		}
	}

}
