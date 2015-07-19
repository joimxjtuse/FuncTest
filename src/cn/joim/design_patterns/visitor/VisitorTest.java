package cn.joim.design_patterns.visitor;

import cn.joim.design_patterns.component.Directory;
import cn.joim.design_patterns.component.File;
import cn.joim.design_patterns.component.Node;
import cn.joim.design_patterns.proxy.Link;

public class VisitorTest {

	public static void main(String[] args) {

		Node mNode = new File(1);

		mNode = new Link(mNode); // set proxy.
		Visitor mVistor = new SuffixPrinterVisitor();
		mNode.accept(mVistor);

		mNode = new Directory();
		mNode.accept(mVistor);
	}

}
