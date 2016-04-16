package cn.joim.design_patterns.flyweight;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FlyWeightMain {

	/**
	 * 大大降低了内存中对象的数量
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Ticket t1 = TicketFactory.getTicket("北京", " 内蒙古");
		t1.showTicketInfo("上铺");

		Ticket t2 = TicketFactory.getTicket("北京", " 内蒙古");
		t2.showTicketInfo("中铺");

		Ticket t3 = TicketFactory.getTicket("北京", " 内蒙古");
		t3.showTicketInfo("下铺");

        ExecutorService exec = Executors.newFixedThreadPool(15);
		for(int i = 0; i < 15; i++){
			Runnable task = new Runnable() {
				@Override
				public void run() {
					ConcurrencyTicketFactory.getTicket("Peking", "Harbin").showTicketInfo("上铺");
				}
			};
			exec.execute(task);
		}
        exec.shutdown();
	}

}
