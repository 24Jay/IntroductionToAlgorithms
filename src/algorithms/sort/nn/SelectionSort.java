package algorithms.sort.nn;

import algorithms.sort.inf.ISort;


/**
 * 选择排序：1...i-1是已经排序好的，从i+1...a[N-1]中选择最小的放在i位置
 * @author jay
 *
 */
public class SelectionSort implements ISort
{

	@Override
	public int[] sort(int[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = i + 1; j < a.length; j++)
			{
				if (a[j] < a[i])
				{
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		return a;
	}

}
