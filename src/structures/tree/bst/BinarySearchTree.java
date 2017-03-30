package structures.tree.bst;

public class BinarySearchTree<T extends Comparable>
{
	private BinaryNode<T> root;

	public BinarySearchTree()
	{
		this.root = null;
	}

	public BinarySearchTree(BinaryNode<T> r)
	{
		this.root = r;
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
		return contains(x, root);
	}

	private boolean contains(T x, BinaryNode<T> r)
	{
		if (x == null || r == null)
			return false;
		if (x.compareTo(r.element) < 0)
			return contains(x, r.left);
		if (x.compareTo(r.element) > 0)
			return contains(x, r.right);
		return true;
	}

	public T findMax()
	{
		return findMax(root).element;
	}

	private BinaryNode<T> findMax(BinaryNode<T> r)
	{
		if (r != null)
			while (r.right != null)
				r = r.right;
		return r;
	}

	public T findMin()
	{
		return findMin(root).element;
	}

	private BinaryNode<T> findMin(BinaryNode<T> r)
	{
		if (r != null)
			while (r.left != null)
				r = r.left;
		return r;
	}

	public void insert(T x)
	{
		this.root = insert(root, x);
	}

	private BinaryNode<T> insert(BinaryNode<T> r, T x)
	{
		if (r == null)
			return new BinaryNode<T>(x);
		if (x.compareTo(r.element) < 0)
		{
			r.left = insert(r.left, x);
		}
		/**
		 * 在使用BinaryTree进行堆排序的时候，如果这里不考虑相等的情况，排序会出现错误
		 */
		if (x.compareTo(r.element) >= 0)
		{
			r.right = insert(r.right, x);
		}

		return r;
	}

	public void remove(T x)
	{
		root = remove(x, root);
	}

	private BinaryNode<T> remove(T x, BinaryNode<T> r)
	{
		if (r == null)
			return r;
		if (x.compareTo(r.element) > 0)
		{
			r.right = remove(x, r.right);
			return r;
		}
		else if (x.compareTo(r.element) < 0)
		{
			r.left = remove(x, r.left);
			return r;
		}
		if (r.left != null && r.right != null)
		{
			r.element = findMin(r.right).element;
			r.right = remove(r.element, r.right);
			return r;
		}
		r = (r.left != null) ? r.left : r.right;
		return r;
	}

	public void walkTree()
	{
		System.out.println("Walking all the element:");
		walkTree(root);
		System.out.println("");
	}

	private void walkTree(BinaryNode<T> r)
	{
		if (r == null)
			return;
		// 左
		if (r.left != null)
			walkTree(r.left);
		// 中
		System.out.print(r.element + "\t");
		// 右
		if (r.right != null)
			walkTree(r.right);
	}

	public BinaryNode<T> getRoot()
	{
		return this.root;
	}
}
