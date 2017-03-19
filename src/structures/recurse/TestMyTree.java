package structures.recurse;

public class TestMyTree
{
	public static void main(String[] ar)
	{
		Tree tree = new Tree();
		System.out.println("DEpfffffth = " + tree.getDepth());
		tree.buildTree();
//		 tree.buildHeavyTree();
		System.out.println("DEpffffffffth = " + tree.getDepth());
		 tree.walkTree();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		// tree.nonRecurseWalking();
	}
}
