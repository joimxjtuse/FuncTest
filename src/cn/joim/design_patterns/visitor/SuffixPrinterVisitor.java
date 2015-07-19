package cn.joim.design_patterns.visitor;

import cn.joim.design_patterns.component.Directory;
import cn.joim.design_patterns.component.File;
import cn.joim.design_patterns.proxy.Link;

public class SuffixPrinterVisitor extends Visitor {

	@Override
	public void visit(File mFile) {

	}

	@Override
	public void visit(Directory mDirectory) {

		System.out.println("/");
	}

	@Override
	public void visit(Link mLink) {

		System.out.println("@");
	}

}
