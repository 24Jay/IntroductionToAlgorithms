package structures.recurse;

public class TestTree
{
	public static void main(String[] ar)
	{
		Tree tree = new Tree();
		tree.buildTree();
//		 tree.buildHeavyTree();
		System.out.println("DEpffffffffth = " + tree.getDepth());
		 tree.walkTree();
		 tree.wildthFirst();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		// tree.nonRecurseWalking();
	}
}
