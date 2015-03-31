package cn.joim.algorithm;

import java.util.Scanner;
import java.util.Stack;

public class RailsAlgorithm {

	/**
	 * 某城市有一个火车站，铁轨铺设如图所示。有n节车厢从A方向驶入车站，按进站顺序为1~n。你的任
	 * 务是判断是否能让它们按照某种特定的顺序进入B。方向的铁轨并驶出车站。例如出栈顺序 （5 4 1 2 3）是不可能 的；（5 4 3 2
	 * 1）是可行的。
	 * 
	 * */
	public static void main(String[] args) {
		// 输入出栈顺序。
		Scanner mScanner = new Scanner(System.in);
		int mArr[] = null;
		if (mScanner.hasNextInt()) {
			String mParamStr = mScanner.nextLine();
			String[] mStrArr = mParamStr.split(" ");
			mArr = new int[mStrArr.length];
			for (int i = 0; i < mStrArr.length; i++) {
				mArr[i] = Integer.valueOf(mStrArr[i]);
			}
		}
		int mPopElent = 1, mArrPosition = 0;
		boolean rightOrder = true;
		Stack<Integer> mStack = new Stack<>();
		while (mArrPosition < mArr.length) {

			if (mPopElent == mArr[mArrPosition]) {
				mPopElent++;
				mArrPosition++;
			} else if (mPopElent <= mArr[mArrPosition]) {
				// 栈顶元素小于 数组的头元素，入栈。
				mStack.push(mPopElent++);
			} else if (!mStack.isEmpty()
					&& mStack.get(mStack.size() - 1) == mArr[mArrPosition]) {
				// 栈顶元素 == 数组的头元素，出栈
				mArrPosition++;
				mStack.pop();
			} else {
				rightOrder = false;
				break;
			}
		}
		System.out.println(rightOrder);
	}
}
