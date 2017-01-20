package sort;

public class TestSort
{
	public static void main(String[] args)
	{
		int[] a =
			{ 23, 22, 5, 56, 44, 3, 21, 23, 58, 14, 9 };
		ISort bubble = new BubbleSort();
		testSort(bubble, a.clone());
		
		ISort selection = new SelectionSort();
		testSort(selection, a.clone());
		
		ISort heap = new HeapSort();
		testSort(heap, a.clone());
		
		
		ISort merge= new MergeSort();
		testSort(merge, a.clone());
//		for (int i = 0; i < a.length; i++)
//			System.out.print(a[i] + "\t");
	}

	private static void testSort(ISort sort, int[] a)
	{
		System.out.println("Sort Algorithm : " + sort.getClass().getName());
		a = sort.sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + "\t");
		System.out.println("");
	}
}
