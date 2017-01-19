package sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTest
{
	public static void main(String[] args)
	{
		List list = new ArrayList<String>();

		list.add("Jay");
		list.add("Miao");
		list.add("Dsuncat");
		list.add(1,list);
		Iterator it = list.iterator();

		while (it.hasNext())
		{
			System.out.println(it.next());
			
		}
		it.remove();
		list.remove("Miao");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$"+it.toString());

		it = list.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
