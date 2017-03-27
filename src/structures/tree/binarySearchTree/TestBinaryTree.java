package structures.tree.binarySearchTree;

public class TestBinaryTree
{
	public static void main(String[] a)
	{
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(new BinaryNode<Integer>(5));

		for (int i = 0; i < 10; i++)
		{
			tree.insert((Integer) i);
			System.out.println("The tree contains " + i + "? " + tree.contains(i));
		}
		System.out.println("Max = " + tree.findMax());
		System.out.println("Min = " + tree.findMin());
		tree.walkTree();
		tree.remove((Integer) 4);
		tree.remove((Integer) 7);
		tree.walkTree();
		tree.insert((Integer) 15);
		tree.walkTree();
	}
}
