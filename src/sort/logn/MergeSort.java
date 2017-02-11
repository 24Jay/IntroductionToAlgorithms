package sort.logn;

import sort.inf.ISort;

/**
 * 归并排序，分治
 */
public class MergeSort implements ISort
{
	@Override
	public int[] sort(int[] a)
	{
		divide(a, 0, a.length-1);
		return a;
	}

	private void divide(int[] a, int low, int high)
	{
		int mid = (low + high) / 2;
		// System.out.println("low=" + low + ", high=" + high);
		if (low < mid)
		{
			divide(a, low, mid);
			divide(a, mid + 1, high);
		}
		merge(a, low, mid, high);
	}

	/*
	 * public static void main(String [] args) { int[] a = { 23, 22, 5, 56, 44,
	 * 3, 21, 23, 58, 14, 9 }; // merge(a, 0, 5, 11); divide(); }
	 */
	private static void merge(int[] a, int low, int mid, int high)
	{
		int[] c = new int[mid - low + 1];
		int[] d = new int[high - mid];
		int j = 0, k = 0;
//		System.out.println("hhhhh" + Arrays.toString(c));
//		System.out.println("dddd" + Arrays.toString(d));
		/**
		 * 先copy两个子序列
		 */
		for (int i = 0; i < c.length; i++)
		{
			c[i] = a[low + i];
		}
		for (int i = 0; i < d.length; i++)
		{
			d[i] = a[mid + 1 + i];
		}

		/**
		 * 排序子序列
		 */
		while (j < c.length && k < d.length)
		{
			if (c[j] < d[k])
				a[low + j + k] = c[j++];
			else
				a[low + j + k] = d[k++];
		}
		/**
		 * Copy多出来的一个剩余
		 */
		if (j < a.length - 1)
		{
			for (int l = 0; l < c.length - j; l++)
				a[low + j + k + l] = c[j + l];
		}
		else
		{
			for (int l = 0; l < d.length - k; l++)
				a[low + j + k + l] = a[k + l];
		}
	}

}
