package cn.joim.design_patterns.prototype;

public class PrototypeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JoimDoc mDoc = new JoimDoc();
		mDoc.setTitle("origin title.");
		mDoc.addImage("origin's first image.");
		mDoc.addImage("origin's second image.");
		mDoc.showDoc();
		JoimDoc mCopyDoc = (JoimDoc) mDoc.clone();
		mCopyDoc.showDoc();

		mCopyDoc.setTitle("copy title");
		mCopyDoc.addImage("copy's first image");
		mDoc.showDoc();
		mCopyDoc.showDoc();
	}

}
