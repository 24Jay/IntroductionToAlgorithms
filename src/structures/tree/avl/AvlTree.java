package structures.tree.avl;

import java.nio.file.attribute.AclEntry.Builder;

public class AvlTree<T extends Comparable<T>>
{
	AvlNode<T> root;

	public AvlTree(AvlNode<T> r)
	{
		this.root = r;
	}

	

	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		return builder.toString();
	}
}
