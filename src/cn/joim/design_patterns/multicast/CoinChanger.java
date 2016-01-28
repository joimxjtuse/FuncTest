package cn.joim.design_patterns.multicast;

public class CoinChanger implements Handler {

	@Override
	public void handle(Event e) {
		CoinInsertedEvent mEvent = (CoinInsertedEvent) e;
		System.out.print("CoinChanger handler:");
		mEvent.coinInsered();
	}
}
