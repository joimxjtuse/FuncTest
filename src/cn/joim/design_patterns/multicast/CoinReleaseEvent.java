package cn.joim.design_patterns.multicast;

public class CoinReleaseEvent implements Event {

	public void amountReleased() {
		System.out.println("it was released.");
	}
}
