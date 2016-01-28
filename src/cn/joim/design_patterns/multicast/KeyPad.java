package cn.joim.design_patterns.multicast;

public class KeyPad implements Handler {

	@Override
	public void handle(Event e) {
		CoinReleaseEvent mEvent = (CoinReleaseEvent) e;
		System.out.print("KeyPad handler:");
		mEvent.amountReleased();
	}
}
