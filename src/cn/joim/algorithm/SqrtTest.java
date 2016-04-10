package cn.joim.algorithm;

public class SqrtTest {

	public static void main(String[] args) {

		int a = 2;
		System.out.println("here:" + Integer.toHexString(128));
		long beginTime = System.currentTimeMillis();
		System.out.println("sqrt(2) = " + Math.sqrt(a));
		long endTime = System.currentTimeMillis();
		System.out.println("system calc time:" + (endTime - beginTime) + " ms");

		// this is an error commit, please ignore it.
		// i have not implement it yet.
		beginTime = System.currentTimeMillis();
		System.out.println("mine sqrt(2) = " + sqrt(a));
		endTime = System.currentTimeMillis();
		System.out.println("mine calc time:" + (endTime - beginTime) + " ms");
	}

	private static float sqrt(float input) {
		float xhalf = 0.5f * input;

		int i = (int) input;
		i = 0x5f37642f - (i >> 1);
		input = (float) i;
		input = input * (1.5f - xhalf * input * input);
		return 1 / input;
	}

}
