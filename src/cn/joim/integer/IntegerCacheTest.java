package cn.joim.integer;

public class IntegerCacheTest {

	public static void main(String[] args) {

		Integer a1 = 100, a2 = 100 ; //integer cache [-128, 127]
		Integer b1 = 200, b2 = 200;
		Integer c1 = 127, c2 = 127;
		System.out.println(a1 == a2);
		System.out.println(b1 == b2);
		System.out.println(c1 == c2);
	}

}
