package cn.joim.design_patterns.flyweight;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TrainTicket implements Ticket {

	private String from;
	private String to;

	private String bunk;

	public int price;

	public TrainTicket(String from, String to) {
		super();
		this.from = from;
		this.to = to;
		this.price = new Random().nextInt(200);
		try {
			// Let's take some time to generate a new ticket;
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showTicketInfo(String bunk) {
		System.out.println("购买从" + from + "到" + to + "的" + bunk + "火车票，价格："
				+ price);
	}

}
