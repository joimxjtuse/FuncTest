package cn.joim.design_patterns.multicast;

public class CoinInsertedEvent implements Event {

	private int mInserted = 0;

	public void coinInsered() {

		System.out.println(mInserted + "$ was inserted");
	}

	public void setCoin(int n) {
		mInserted = n;
	}

}
