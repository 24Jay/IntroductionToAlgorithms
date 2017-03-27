package structures.tree.BTree;

public class Node<T>
{
	private T element;

	private Node[] children = new Node[5];

	public Node(T e, Node[] ch)
	{
		this.element = e;
		this.children = ch;
	}

	public T getElement()
	{
		return element;
	}

	public void setElement(T element)
	{
		this.element = element;
	}

	public Node[] getChildren()
	{
		return children;
	}

	public void setChildren(Node[] children)
	{
		this.children = children;
	}

}
