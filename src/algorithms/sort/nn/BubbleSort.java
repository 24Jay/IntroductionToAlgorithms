package algorithms.sort.nn;

import algorithms.sort.inf.ISort;


/**
 * 冒泡排序：与选择排序相反，从0....i中选择最大的放在数组后面
 * @author jay
 *
 */
public class BubbleSort implements ISort
{
	@Override
	public int[] sort(int[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a.length - i - 1; j++)
			{
				if (a[j] > a[j + 1])
				{
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
		return a;
	}
}
