package sort.logn;

import dataStructure.bst.BinaryNode;
import dataStructure.bst.BinarySearchTree;
import sort.ISort;

public class HeapSort implements ISort
{
	private int[] result;
	private int i = 0;

	@Override
	public int[] sort(int[] a)
	{
		result = a;
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		for (int i = 0; i < a.length; i++)
			tree.insert((Integer) a[i]);
		BinaryNode<Integer> root = tree.getRoot();
		walk(root);
		return result;
	}

	private void walk(BinaryNode<Integer> root)
	{
		if (root == null)
			return;
		if (root.left != null)
			walk(root.left);
		result[i++] = root.element;
		if (root.right != null)
			walk(root.right);
	}

}
