package DataStructure.bst;

public class BinarySearchTree<T extends Comparable>
{
	private BinaryNode<T> root;

	public BinarySearchTree()
	{
		this.root = null;
	}

	public void makeEmpty()
	{
		this.root = null;
	}

	public boolean isEmpty()
	{
		return null == (this.root);
	}
	
	public boolean contains(T x)
	{
		return contains(x,root);
	}
	
	private boolean contains(T x, BinarySearchTree<T> tree)
	{
		if(tree == null)
			return false;
		if(x.compareTo(tree.el)tree.e)
	}
}
