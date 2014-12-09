package cn.joim.string.sub;

import java.util.Stack;

/**
 * 进制转换。
 * 
 * 
 * */
public class AnyDecimalConverter {

	private static final String HEX_MAX = "0123456789abcdefghijklmnopqrstuvwxyz";
	private static final int DEFAULT_HEX = 10;

	/**
	 * 
	 * HTTP协议本身未指定任何对URL长度要求。它只是建议不要超过255个字符，因为有些很老的客户端
	 * 或者代理只能接收小于255个字符的URL，服务器本身不限制URL的长度；我们有一项业务需求是根据 一串用户ID去获取一些信息，
	 * 比如等级，10进制的ID一般是8个左右，中间“-”，需要获取20个用户 的信息，最多就是
	 * 20x8+19,如果自身url就比较长，那就很容易被截断了，所以想到了32进制字符 串去封装数据。 继而突发奇想写了写任意进制的转换。
	 * 
	 * */
	public String decorateGuid(String guid) {
		return converterSrcHextoDesHex(guid, DEFAULT_HEX, HEX_MAX.length());
	}

	/**
	 * 任意进制的转换， 先将 src的进制统一替换为10进制，继而 由10进制再转换成给定的进制数.
	 * */
	public String converterSrcHextoDesHex(String src, int srcHex, int desHex) {

		if (srcHex == 0 || desHex == 0) {
			throw new RuntimeException("error hex, there has no zero hex.");
		}
		if (srcHex > HEX_MAX.length() || desHex > HEX_MAX.length()) {
			throw new RuntimeException("error hex, too big.");
		}
		if (src == null || src.length() <= 0) {
			throw new RuntimeException("error input no input or null.");
		}
		// TODO src 的每一个char在 HEX_MAX内都可以找到.
		if (srcHex == desHex) {
			return src;
		}
		if (desHex != DEFAULT_HEX) {
			src = converterSrcHextoDesHex(src, srcHex, DEFAULT_HEX);
		} else {
			char[] charsArray = src.toCharArray();
			int len = charsArray.length;
			long n = 0;
			for (int i = len - 1; i >= 0; i--) {
				n += HEX_MAX.indexOf(charsArray[i])
						* Math.pow(srcHex, len - i - 1);
			}
			return String.valueOf(n);
		}
		return baseString(src, desHex);
	}

	/**
	 * 将十进制数转换为任意进制。
	 * 
	 * */
	public String baseString(String num, int base) {

		if (num == null || num.length() <= 0) {
			throw new RuntimeException("error input.");
		}
		if (base > HEX_MAX.length()) {
			throw new RuntimeException("error hex, too big.");
		}

		Long mLong = new Long(num);

		StringBuffer str = new StringBuffer("");
		Stack<Character> mStack = new Stack<Character>();
		while (mLong != 0) {
			mStack.push(HEX_MAX.charAt((int) (mLong % base)));
			mLong = mLong / base;
		}
		while (!mStack.isEmpty()) {
			str.append(mStack.pop());
		}
		return str.toString();

	}

	public static void main(String[] args) {
		/**
		 * TODO 1.传递过来的为非法字符，#￥%……； 2.
		 * 
		 * */
		AnyDecimalConverter mHexConverter = new AnyDecimalConverter();
		System.out.println("Encode GUID:"
				+ mHexConverter.decorateGuid("5984352"));
		System.out.println("10 - 2:"
				+ mHexConverter.converterSrcHextoDesHex("110011001", 2, 10));

	}

}
