package cn.joim.design_patterns.component;

/**
 * 我们可以在以下场合使用Component模式：</br> 1. 我们想要表示对象的“部分-整体”层次结构； </br>2.
 * 我们想要用户能够忽略复合对象和单个对象之间的区别。
 * 
 * 
 * 
 * */
public interface Node {

	/**
	 * 对文件和目录来说，他们都有共同的属性，比如名字、大小等，每个属性都哟与相应的操作来访问以及修改值。
	 * 
	 * */

	/**
	 * 返回文件或文件目录树所占用的送字节数。
	 * 
	 * */
	public int size();

	/**
	 * 
	 * 返回第n个子节点。
	 * */
	public Node get(int n);
}
