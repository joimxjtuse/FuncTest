package cn.joim.design_patterns.proxy;

import cn.joim.design_patterns.component.Node;
import cn.joim.design_patterns.visitor.Visitor;

public class Link implements Node {

	/**
	 * 
	 * Proxy：用来维护一个引用，并让该代理去访问实际对象。 </br> so, mProxyNode = File/Directory.
	 * 
	 * */
	Node mProxyNode;

	public Link(Node mProxy) {
		this.mProxyNode = mProxy;
	}

	@Override
	public int size() {
		return mProxyNode.size();
	}

	@Override
	public Node get(int n) {
		return mProxyNode.get(n);
	}

	@Override
	public void accept(Visitor mVisitor) {
		if (null != mVisitor) {
			mVisitor.visit(this);
		}
	}

}
