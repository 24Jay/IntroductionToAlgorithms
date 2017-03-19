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
		this.root = new TreeNode("root", new LinkedList<TreeNode>());
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
		System.out.println("Depth = " + depth);
		if (depth > 5000)
			return;
		TreeNode a = new TreeNode("left_" + depth, new ArrayList<>());
		TreeNode b = new TreeNode("right_" + depth, new ArrayList<>());
		r.addChild(a);
		r.addChild(b);
		depth++;
		heavyTree(a);
		heavyTree(b);
	}

	public static void main(String[] ar)
	{
		Tree tree = new Tree();
		// tree.buildTree();
		tree.buildHeavyTree();
		tree.walkTree();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		tree.nonRecurseWalking();
	}
}
