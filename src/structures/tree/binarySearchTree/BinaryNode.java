package structures.tree.binarySearchTree;

public class BinaryNode<T>
{
	public T element;
	public BinaryNode<T> left;
	public BinaryNode<T> right;

	public BinaryNode(T e)
	{
		this.element = e;
		this.left = null;
		this.right = null;
	}

	public BinaryNode(T e, BinaryNode<T> left, BinaryNode<T> right)
	{
		this.element = e;
		this.left = left;
		this.right = right;
	}

}
