package cn.joim.design_patterns.component;

import cn.joim.design_patterns.visitor.Visitor;

public class File implements Node {

	private int size;

	public File(int size) {
		this.size = size;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Node get(int n) {
		throw new UnsupportedOperationException(
				"this operation is not supported");
	}

	@Override
	public void accept(Visitor mVisitor) {
		if (null != mVisitor) {
			mVisitor.visit(this);
		}
	}

}
