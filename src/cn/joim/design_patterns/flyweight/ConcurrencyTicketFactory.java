package cn.joim.design_patterns.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ConcurrencyTicketFactory {

    private static Map<String, Ticket> sTicket = new ConcurrentHashMap<String, Ticket>();
    private final static Object myLock = new Object();

    public static Ticket getTicket(String from, String to) {
        Ticket ticket = null;
        String key = from + "-" + to;
        if (sTicket.containsKey(key)) {
            System.out.println("use cache.");
            ticket = sTicket.get(key);
        } else {
            synchronized (myLock) {
                if(sTicket.containsKey(key)){
                    System.out.println("use cache.");
                    ticket = sTicket.get(key);
                } else {
                    System.out.println("new ticket");
                    ticket = new TrainTicket(from, to);
                    sTicket.put(key, ticket);
                }
            }
        }
        return ticket;
    }
}
