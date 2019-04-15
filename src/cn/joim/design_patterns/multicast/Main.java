package cn.joim.design_patterns.multicast;

import java.util.Observable;

public class Main {

	/**
	 * 摘自《设计模式沉思录》 Multicast模式，展示了一种将信息传递给感兴趣的对象的方式，这种方式不仅可以扩展， 而且能够在静态保证类型的安全性。
	 * <b>
	 * 
	 * [首先，我所写的这段demo是根据自我的理解所实现的，不到之处还是希望能够批评指正。] <b>
	 * 这个模式我可以说读了三遍（这本书也是三遍了，伴随了我对设计模式从理论
	 * ->模仿->认识->设计代码的过程），时间间隔是三年左右；第一次阅读，算是粗略飘过，因为那会刚上研一，对于设计模式还只是理论上的模拟；
	 * 第二次阅读，是研三面试的时候，那会虽然有了一些代码的沉淀，但还是仅仅以为这也是个Observer（当然我没有亲自模仿过），依然mark
	 * 了一下；今天是第三次阅读，此时已工作了两年，自我感悟是这个设计牺牲了扩展性，但好处是它可以是针对一系列功能的一套框架了。 <b>
	 * 这样说，是因为，这次看了这段设计感觉我之前的一套功能，如果套用这套设计，也许可以更美些。需求就是：客户端的消息提醒功能。
	 * 消息包括用户与等级有关的金币
	 * 、经验更新消息，商城新活动有关的提醒消息，以及与用户评论有关的消息提醒。每一个消息可能都在不同的Activity页面内做相应的UI交互 。
	 * 当时，我咋一听需求，当时就想到了这是一种一（也许一不恰当，但至少每一个消息都对应多个吧）对多的以来关系，随即，我就定义了Subject和
	 * Observer。
	 * 问题来了，不同的消息Bean都不一样啊，怎么办，都堆到一个Bean里面；no，有相同的字段；好吧，update(message)
	 * 的message就用Object吧，当Subject调用notifyAll时根据类型来过滤不需要处理的消息。 <b>
	 * 
	 * 嗯，这段代码也运行了半年多，似乎效果还不错，但是看了这个模式后，好像所有的update方法内都通过intsanceof来增加过滤，
	 * 而且for循环走了不必要的遍历，如果我定义ShoppingMessageEvent，
	 * UserCommentMessageEvent和UserInfoMessageEvent，这样， 遍历就不再需要处理不需要的地方。
	 */
	public static void main(String[] args) {

		Registry mRegistry = new Registry();

		CoinInsertedEvent mCoinInsertedEvent = new CoinInsertedEvent();
		CoinReleaseEvent mCoinReleaseEvent = new CoinReleaseEvent();

		CoinChanger mChangerHandler = new CoinChanger();
		KeyPad mKeyPad = new KeyPad();

		Observable o;

		/**
		 * mChangerHandler 和内部类定义的Handler仅接收硬币插入的事件。
		 * */
		mRegistry.register(mCoinInsertedEvent, mChangerHandler);
		mRegistry.register(mCoinInsertedEvent, new Handler() {

			@Override
			public void handle(Event e) {
				CoinInsertedEvent mEvent = (CoinInsertedEvent) e;
				System.out.print("second(insert) handler:");
				mEvent.coinInsered();
			}
		});

		/**
		 * mKeyPad 和内部类定义的Handler仅接收硬币退出的事件。
		 * */
		mRegistry.register(mCoinReleaseEvent, mKeyPad);
		mRegistry.register(mCoinReleaseEvent, new Handler() {

			@Override
			public void handle(Event e) {
				CoinReleaseEvent mEvent = (CoinReleaseEvent) e;
				System.out.print("second(release) handler:");
				mEvent.amountReleased();
			}
		});

		mCoinInsertedEvent.setCoin(12);
		mRegistry.notify(mCoinInsertedEvent);
		
		mCoinReleaseEvent.setReleased(66);
		mRegistry.notify(mCoinReleaseEvent);

	}
}
