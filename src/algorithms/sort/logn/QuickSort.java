package algorithms.sort.logn;

import algorithms.sort.inf.ISort;

public class QuickSort implements ISort
{

	@Override
	public int[] sort(int[] a)
	{
		quick(a, 0, a.length - 1);
		return a;
	}

	private void quick(int[] a, int low, int high)
	{
		if (low >= high)
			return;
		int tick = exchange(a, 0, (low + high) / 2, high);
		quick(a, low, tick - 1);
		quick(a, tick + 1, high);
	}

	/*
	 * public static void main(String[] args) { int[] a = { 23, 22, 5, 56, 44,
	 * 3, 21, 23, 58, 14, 9 }; int tick = exchange(a, 0, 3, a.length - 1);
	 * System.out.println(Arrays.toString(a)); System.out.println(tick); }
	 */

	private int exchange(int[] a, int low, int tick, int high)
	{

		for (int i = low; i <= high; i++)
		{
			if (a[i] > a[tick] && i < tick)
			{
				int tmp = a[i];
				for (int j = i + 1; j <= tick; j++)
				{
					a[j - 1] = a[j];
				}
				a[tick] = tmp;
				tick--;
				i--;
				continue;
			}
			// .Arrays.
			if (a[i] < a[tick] && i > tick)
			{
				int tmp = a[i];
				for (int j = i; j > tick; j--)
				{
					a[j] = a[j - 1];
				}
				a[tick] = tmp;
				tick++;
				continue;
			}
		}
		return tick;

	}

}
