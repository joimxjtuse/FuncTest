package cn.joim.string.sub;

/**
 * 
 * 截取8个字符的中文昵称， 其英文算半个字符,中文算1个字符。 </br>
 * 
 * 输入：“joim你好，大苏打丰富的斯蒂芬” 输出：“joim你好，大苏打” 10个字符</br> 输入：“发生的房贷首付第三方的首付第”
 * 输出：“发生的房贷首付第” 8个中文字符. </br> 输入：“fsdfsfsdfdsfdsdfdsfdsf” 输出：“fsdfsfsdfdsfdsdf”
 * 16个英文字符。 </br> 输入：“打算fdfd发生g的房首付第三方岁” 输出：“打算fdfd发生g的房” 8.5</br> 1--1/2</br>
 * */
public class SubStringMyNickName {

	private static final int SUBSTRING_LENGTH = 8;

	public String subMyNickName(String mName) {

		return subStrigByLanguage(mName, SUBSTRING_LENGTH);
	}

	private String subStrigByLanguage(String res, int length) {
		if (0 == length) {
			return "";
		}
		if (isEmpty(res) || res.length() <= length) {
			return res;
		}
		StringBuilder mStringBuilder = new StringBuilder();
		int resultLength = 0;
		for (int i = 0, mResLength = res.length(); i < mResLength
				&& resultLength < 2 * length; i++) {

			char c = res.charAt(i);
			if (!isLetter(c)) {
				// 非英文字符.
				resultLength += 2;
			} else {
				resultLength += 1;
			}
			mStringBuilder.append(c);
		}
		return mStringBuilder.toString();
	}

	/**
	 * 检测是汉字还是英文或数字
	 * 
	 * @param c
	 * @return
	 */
	private boolean isLetter(char c) {
		int k = 0x80;
		return c / k == 0 ? true : false;
	}

	private boolean isEmpty(String res) {
		if (null == res || 0 == res.length())
			return true;
		else
			return false;
	}

}
