package cn.joim.design_patterns.multicast;

public class CoinReleaseEvent implements Event {

	private int mReleased = 0;

	public void amountReleased() {
		System.out.println(mReleased + "$ was released.");
	}

	public void setReleased(int n) {
		this.mReleased = n;
	}
}
