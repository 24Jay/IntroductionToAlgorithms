package sort;

import java.util.Arrays;

import sort.inf.ISort;
import sort.logn.HeapSort;
import sort.logn.MergeSort;
import sort.logn.QuickSort;
import sort.nn.BubbleSort;
import sort.nn.InsertionSort;
import sort.nn.SelectionSort;

public class TestSort
{
	/**
	 * 使用的是命令模式，来测试各种排序算法
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] a =
			{ 23, 22, 5, 56, 44, 3, 21, 23, 58, 14, 9, 10, 9, 56, 89, 51, 74, 76, 78, 66 };

		/**
		 * 冒泡，选择，插入 ：这三个排序算法的平均时间复杂度为O(n*n)
		 */
		// 冒泡排序
		ISort bubble = new BubbleSort();
		testSort(bubble, a.clone());

		// 选择排序
		ISort selection = new SelectionSort();
		testSort(selection, a.clone());

		// 插入排序
		ISort insert = new InsertionSort();
		testSort(insert, a.clone());

		/**
		 * 堆排序，归并排序，快速排序 ：这三个的平均时间复杂度均为log(n)*n
		 */
		// 堆排序
		ISort heap = new HeapSort();
		testSort(heap, a.clone());

		// 归并排序
		ISort merge = new MergeSort();
		testSort(merge, a.clone());

		// 快速排序
		ISort quick = new QuickSort();
		testSort(quick, a.clone());

		/**
		 * 桶排序和bitmap排序其实质是一样的
		 */
		// 桶排序
		ISort buck = new BuckSort();
		testSort(buck, a.clone());

		// bitmap
		ISort bitmap = new BitmapSort();
		testSort(bitmap, a.clone());

		/**
		 * 打印初始数组
		 */
		System.out.println("*******************original Array*********************** ");
		System.out.println(Arrays.toString(a));
	}

	private static void testSort(ISort sort, int[] a)
	{
		System.out.println("Sort Algorithm : " + sort.getClass().getName());
		a = sort.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
