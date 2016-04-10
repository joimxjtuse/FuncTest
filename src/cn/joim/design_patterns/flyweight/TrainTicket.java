package cn.joim.design_patterns.flyweight;

import java.util.Random;

public class TrainTicket implements Ticket {

	private String from;
	private String to;

	private String bunk;

	public int price;

	public TrainTicket(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}

	@Override
	public void showTicketInfo(String bunk) {
		price = new Random().nextInt(200);
		System.out.println("购买从" + from + "到" + to + "的" + bunk + "火车票，价格："
				+ price);
	}

}
