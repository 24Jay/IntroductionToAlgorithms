package DataStructure.bst;

public class BinaryNode<T>
{
	T element;
	BinaryNode<T> left;
	BinaryNode<T> right;
	
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
