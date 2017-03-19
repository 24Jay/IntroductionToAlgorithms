package structures.recurse;

import java.util.List;

/****
 * 一个树的节点<br>
 * 
 * @author jay
 *
 */
public class TreeNode
{
	String name;

	List<TreeNode> children;

	public TreeNode(String n, List<TreeNode> list)
	{
		this.name = n;
		this.children = list;
	}

	public boolean addChild(TreeNode n)
	{
		if (children == null)
			return false;
		return this.children.add(n);
	}

	public TreeNode popChild()
	{
		if (children == null || children.isEmpty())
			return null;
		return children.remove(0);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<TreeNode> getChildren()
	{
		return children;
	}

	public void setChildren(List<TreeNode> children)
	{
		this.children = children;
	}

}
