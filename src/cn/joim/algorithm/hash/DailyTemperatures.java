package cn.joim.algorithm.hash;

import java.util.Stack;

/**
 * 739. 每日温度
 * <p>
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，
 * 请输入 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {

        return dailyTemperaturesGood(T);
    }


    /**
     * O(n^2)
     */
    public int[] dailyTemperaturesWorst(int[] T) {

        int result[] = new int[T.length];
        result[T.length - 1] = 0;

        for (int i = 0; i < T.length - 1; i++) {

            int countDay = 0;

            for (int j = i + 1; j < T.length; j++) {

                countDay++;
                if (T[i] >= T[j]) {
                    if (j == T.length - 1) {
                        countDay = 0;
                    }
                } else {
                    break;
                }
            }
            result[i] = countDay;

        }
        return result;
    }

    /**
     *
     */
    public int[] dailyTemperaturesGood(int[] T) {
        int result[] = new int[T.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {

            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int position = stack.pop();
                result[position] = i - position;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {

        int T[] = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int result[] = new DailyTemperatures().dailyTemperatures(T);
        System.out.println();
    }
}
