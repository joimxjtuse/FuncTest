package cn.joim.integer;

public class IntegerCacheTest {

	/**
	 * from java.lang.Integer.IntegerCache, when first user integer, it will
	 * init 256 integer cache,from -128 to 127.]
	 * 
	 * 
	 * this is an test branch.
	 * */
	public static void main(String[] args) {

		// Integer a1 = Integer.valueOf(100), b = Integer.valueOf(100) ;
		Integer a1 = 100, a2 = 100;
		Integer b1 = 200, b2 = 200;
		Integer c1 = 127, c2 = 127;
		System.out.println(a1 == a2); // true
		System.out.println(b1 == b2); // false
		System.out.println(c1 == c2); // true
	}

}
