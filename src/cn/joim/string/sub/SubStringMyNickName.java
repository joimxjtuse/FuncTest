package cn.joim.string.sub;

/**
 * 
 * ��ȡ8���ַ��������ǳƣ� ��Ӣ�������ַ�,������1���ַ��� </br>
 * 
 * ���룺��joim��ã����մ�ḻ��˹�ٷҡ� �������joim��ã����մ� 10���ַ�</br> ���룺�������ķ����׸����������׸��ڡ�
 * ������������ķ����׸��ڡ� 8�������ַ�. </br> ���룺��fsdfsfsdfdsfdsdfdsfdsf�� �������fsdfsfsdfdsfdsdf��
 * 16��Ӣ���ַ��� </br> ���룺������fdfd����g�ķ��׸��������ꡱ �����������fdfd����g�ķ��� 8.5</br> 1--1/2</br>
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
				// ��Ӣ���ַ�.
				resultLength += 2;
			} else {
				resultLength += 1;
			}
			mStringBuilder.append(c);
		}
		return mStringBuilder.toString();
	}

	/**
	 * ����Ǻ��ֻ���Ӣ�Ļ�����
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
