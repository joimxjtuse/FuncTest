package cn.joim.design_patterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class JoimDoc implements Cloneable {

	private String title;

	private ArrayList<String> mImages;

	public void setTitle(String title) {
		this.title = title;
	}

	public void addImage(String imgDes) {
		if (null == mImages) {
			mImages = new ArrayList<String>();
		}
		mImages.add(imgDes);
	}

	@Override
	protected Object clone() {

		try {
			/***
			 * return super.clone(); 仅仅是浅拷贝.
			 */
			JoimDoc coptDoc = (JoimDoc) super.clone();
			/**
			 * String.java中引用类型是一种浅拷贝，只是它们所指向的都是字符串常量池中的常量，
			 * 对于String类型A和copyA，修改copyA之后A没有修改。
			 * 
			 * A = "abc"; copyA.clone()相当与copyA = "abc"; copyA = "bcd";相当于copyA
			 * 指向了字符串常量池里面的"bcd"，而A没有改变引用地址。
			 * */
			coptDoc.title = this.title;
			/**
			 * 深拷贝. ArrayList.clone内对数组进行了拷贝。
			 * */
			coptDoc.mImages = (ArrayList<String>) this.mImages.clone();
			return coptDoc;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void showDoc() {

		System.out.println("----------start show----------");
		System.out.println("title: " + title);
		System.out.println("images:");
		if (null != mImages && !mImages.isEmpty()) {
			for (String imageDes : mImages) {
				System.out.println("  " + imageDes);
			}
		}
		System.out.println("----------end show----------");
	}

}
