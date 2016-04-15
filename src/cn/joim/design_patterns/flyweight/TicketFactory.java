package cn.joim.design_patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TicketFactory {

	private static Map<String, Ticket> sTicket = new HashMap<String, Ticket>();

	public static Ticket getTicket(String from, String to) {
		String key = from + "-" + to;
		if (sTicket.containsKey(key)) {
			System.out.println("use cache.");
			return sTicket.get(key);
		} else {
			// Todo the following code is not safe for multi treading programming, should add lock,
			// double check containsKey inside the lock before put new ticket.
			System.out.println("new ticket");
			Ticket ticket = new TrainTicket(from, to);
			sTicket.put(key, ticket);
			return ticket;
		}
	}
}
