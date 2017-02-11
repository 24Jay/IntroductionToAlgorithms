package sort;

import sort.logn.HeapSort;
import sort.logn.MergeSort;
import sort.logn.QuickSort;
import sort.nn.BubbleSort;
import sort.nn.InsertionSort;
import sort.nn.SelectionSort;

public class TestSort
{
	public static void main(String[] args)
	{
		int[] a =
			{ 23, 22, 5, 56, 44, 3, 21, 23, 58, 14, 9, 10, 9, 56, 89, 51, 74, 76, 78, 66 };
		ISort bubble = new BubbleSort();
		testSort(bubble, a.clone());

		ISort selection = new SelectionSort();
		testSort(selection, a.clone());

		ISort heap = new HeapSort();
		testSort(heap, a.clone());

		ISort merge = new MergeSort();
		testSort(merge, a.clone());

		ISort quick = new QuickSort();
		testSort(quick, a.clone());

		ISort buck = new BuckSort();
		testSort(buck, a.clone());
		
		ISort insert = new InsertionSort();
		testSort(insert, a.clone());

		System.out.println("*******************original Array*********************** ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + "\t");
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
