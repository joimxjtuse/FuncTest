package cn.joim.design_patterns.component;

import java.util.ArrayList;
import java.util.List;

import cn.joim.design_patterns.visitor.Visitor;

public class Directory implements Node {

	private List<Node> nodes;

	public Directory() {
		nodes = new ArrayList<Node>();
	}

	@Override
	public int size() {
		int size = 0;
		for (Node mNode : nodes) {
			size += mNode.size();
		}
		return size;
	}

	@Override
	public Node get(int n) {

		return nodes.get(n);
	}

	@Override
	public void accept(Visitor mVisitor) {
		if (null != mVisitor) {
			mVisitor.visit(this);
		}
	}

}
