package structures.recurse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree
{
	private TreeNode root;

	private int depth = 0;

	public Tree()
	{
		this.root = new TreeNode("/", new LinkedList<TreeNode>());
		TreeNode r = new TreeNode("root", new LinkedList<TreeNode>());
		root.addChild(r);
	}

	public int getDepth()
	{
		return countDepth(root);
	}

	public int countDepth(TreeNode r)
	{
		List<TreeNode> list = r.getChildren();
		if (list == null || list.isEmpty())
			return 1;
		int maxChild = 0;
		for (TreeNode node : list)
		{
			if (maxChild < countDepth(node))
				maxChild = countDepth(node);
		}
		System.out.println("maxCHild = " + maxChild);
		return maxChild + 1;

	}

	public void buildTree()
	{
		TreeNode bin = new TreeNode("bin", null);
		TreeNode usr = new TreeNode("usr", null);
		TreeNode var = new TreeNode("var", new LinkedList<TreeNode>());
		TreeNode log = new TreeNode("log", null);
		var.addChild(log);

		TreeNode home = new TreeNode("home", new LinkedList<TreeNode>());
		TreeNode jay = new TreeNode("jay", new LinkedList<TreeNode>());
		home.addChild(jay);
		TreeNode linux = new TreeNode("linux", null);
		TreeNode workspace = new TreeNode("workspace", null);
		TreeNode python = new TreeNode("python", null);

		jay.addChild(linux);
		jay.addChild(python);
		jay.addChild(workspace);

		root.addChild(bin);
		root.addChild(var);
		root.addChild(usr);
		root.addChild(home);
	}

	public void depthFirst()
	{

	}

	public void wildthFirst()
	{
		System.out.println(root.getName());
		wildthF(root);
	}

	private void wildthF(TreeNode r)
	{

		List<TreeNode> children = r.getChildren();
		if (children != null)
		{
			for (TreeNode n : children)
				System.out.print(n.getName() + "\t");
			System.out.println("");
			for (TreeNode n : children)
				wildthF(n);
		}
	}

	public void walkTree()
	{
		System.out.print("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("Walking tree with STACKKKKKKKKKKKKK");
		walkWithRecurse(root);
	}

	/***
	 * 用递归实现Tree的遍历,本质上是利用了虚拟机栈,因此如果TreeNode很多,会出现StackOverFLow<br>
	 * 
	 * @param r
	 */
	private void walkWithRecurse(TreeNode r)
	{

		if (r == null)
		{
			System.out.println("A null tree!");
			return;
		}
		System.out.println(r.getName());

		if (r.getChildren() != null)
		{
			List<TreeNode> children = r.getChildren();
			for (TreeNode node : children)
				walkWithRecurse(node);
		}
		// System.out.println(r.getName());

	}

	public void nonRecurseWalking()
	{
		nonRecurseWalking(root);
	}

	/***
	 * 利用另外一种数据结构Queue实现非递归的调用<br>
	 * 因此,就不会产生StackOverFlow的错误<br>
	 * 
	 * @param r
	 */
	private void nonRecurseWalking(TreeNode r)
	{
		System.out.print("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("Walking tree with Queueeeeeeeeeeeeeeeeeeeeeeeeeee");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(r);
		while (!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			System.out.println(node.getName());
			List<TreeNode> list = node.getChildren();
			if (list != null)
				queue.addAll(list);
			// for(TreeNode n:)
		}

	}

	public void buildHeavyTree()
	{
		heavyTree(root);
	}

	private void heavyTree(TreeNode r)
	{
		if (depth > 100)
			return;
		TreeNode a = new TreeNode("left_" + depth, new ArrayList<>());
		TreeNode b = new TreeNode("right_" + depth, new ArrayList<>());
		r.addChild(a);
		r.addChild(b);
		depth++;
		heavyTree(a);
		heavyTree(b);
	}

}
