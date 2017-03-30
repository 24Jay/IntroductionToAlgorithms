package structures.tree.avl;

public class AvlNode<T extends Comparable<T>>
{
	T element;

	AvlNode<T> left;

	AvlNode<T> right;

	int height;

	public AvlNode(T t, AvlNode<T> left, AvlNode<T> right)
	{
		this.element = t;
		this.left = left;
		this.right = right;
		this.height = 0;
	}

	AvlNode(T t)
	{
		this(t, null, null);
	}

	public int height()
	{
		return height;
	}

	public String toString()
	{
		return "[" + this.element + "=" + element + "left->" + left.element + ", right->"
				+ right.element + "]";
	}

	public void insert(T e, AvlNode<T> r)
	{
		if (r == null)
		{
			new AvlNode<T>(e);
			return;
		}
		int cmp = e.compareTo(r.element);
		if (cmp < 0)
		{
			insert(e, r.left);
			if (r.left.height - r.right.height == 2)
			{
				if (e.compareTo(r.left.element) < 0)
					r = rotateWithLeftChild(r);
				else
					r = doubleWithLeftChild(r);
			}
		}
		else if (cmp > 0)
		{
			insert(e, r.right);
			if (r.right.height - r.left.height == 2)
			{
				if (e.compareTo(r.right.element) > 0)
					r = rotateWithRightChild(r);
				else
					r = doubleWithLeftChild(r);
			}
		}
		r.height = Math.max(r.left.height, r.right.height) + 1;
	}

	private AvlNode<T> rotateWithLeftChild(AvlNode<T> r)
	{
		AvlNode<T> left = r.left;
		AvlNode<T> y = left.right;
		left.right = r;
		r.left = y;
		r.height = Math.max(r.right.height, y.height) + 1;
		left.height = Math.max(left.left.height, r.height) + 1;
		return left;
	}

	private AvlNode<T> doubleWithLeftChild(AvlNode<T> r)
	{
		r.left = rotateWithRightChild(r.left);
		r = rotateWithLeftChild(r);
		return r;
	}

	private AvlNode<T> rotateWithRightChild(AvlNode<T> r)
	{
		AvlNode<T> right = r.right;
		AvlNode<T> right_left = r.left;

		right.left = r;
		r.right = right_left;
		r.height = Math.max(r.right.height, r.left.height) + 1;
		right.height = Math.max(right.right.height, right.left.height) + 1;
		return right;
	}

	private AvlNode<T> doubleWithRightChild(AvlNode<T> r)
	{
		r.right = rotateWithLeftChild(r.right);
		r = rotateWithRightChild(r);
		return r;
	}
}
