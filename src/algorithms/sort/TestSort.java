package algorithms.sort;

import java.util.Arrays;

import algorithms.sort.inf.ISort;
import algorithms.sort.logn.HeapSort;
import algorithms.sort.logn.MergeSort;
import algorithms.sort.logn.QuickSort;
import algorithms.sort.nn.BubbleSort;
import algorithms.sort.nn.InsertionSort;
import algorithms.sort.nn.SelectionSort;

public class TestSort
{
	/**
	 * 使用的是命令模式，来测试各种排序算法
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		test();
		System.out.println("\n\n**********************TestByRefletion***********************");
		testByReflection();
	}

	private static void test()
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

	/**
	 * 应用反射来进行测试
	 */
	private static void testByReflection()
	{

		int[] a =
			{ 23, 22, 5, 56, 44, 3, 21, 23, 58, 14, 9, 10, 9, 56, 89, 51, 74, 76, 78, 66 };
		/**
		 * 各路排序算法类
		 */
		String[] algo =
			{ "algorithms.sort.nn.BubbleSort", "algorithms.sort.nn.SelectionSort",
					"algorithms.sort.nn.InsertionSort", "algorithms.sort.logn.HeapSort",
					"algorithms.sort.logn.MergeSort", "algorithms.sort.logn.QuickSort",
					"algorithms.sort.BuckSort" };
		for (String name : algo)
		{
			String cl = name;// + ".class";
			try
			{
				Class<?> c = Class.forName(cl);
				ISort sortion = (ISort) c.newInstance();
				testSort(sortion, a.clone());
			}
			catch (ClassNotFoundException | InstantiationException | IllegalAccessException e)
			{
				e.printStackTrace();
			}

		}

	}

	/***
	 * 调用方法进行测试
	 * 
	 * @param sort
	 * @param a
	 */
	private static void testSort(ISort sort, int[] a)
	{
		System.out.println("Sort Algorithm : " + sort.getClass().getName());
		a = sort.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
