package cn.joim.design_patterns.visitor;

import cn.joim.design_patterns.component.Directory;
import cn.joim.design_patterns.component.File;
import cn.joim.design_patterns.proxy.Link;

public abstract class Visitor {

	/**
	 * Node类提供的accept()让Visitor对象去访问一个制定的节点.
	 * 
	 * 访问者模式： 不需修改待处理元素的类，就可以定义新的操作.
	 * 
	 * */

	public Visitor() {

	}

	public Visitor(final Visitor mVisitor) {

	}

	public abstract void visit(File mFile);

	public abstract void visit(Directory mDirectory);

	public abstract void visit(Link mLink);

}
