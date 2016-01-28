package cn.joim.design_patterns.multicast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Registry {

	private Map<Event, List<Handler>> map;

	public Registry() {
		map = new HashMap<Event, List<Handler>>();
	}

	public void register(Event e, Handler h) {
		if (null == e || null == h) {
			return;
		}
		List<Handler> mHandlers = map.get(e);
		if (null == mHandlers) {
			mHandlers = new ArrayList<Handler>();
			map.put(e, mHandlers);
		}
		if (!mHandlers.contains(e)) {
			mHandlers.add(h);
		}
	}

	public void notify(Event e) {
		if (null == e) {
			return;
		}
		List<Handler> mHandlers = map.get(e);
		if (null != mHandlers && !mHandlers.isEmpty()) {
			for (Handler h : mHandlers) {
				h.handle(e);
			}
		}
	}
}
