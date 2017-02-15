package algorithms.sort;

import algorithms.sort.inf.ISort;

public class BuckSort implements ISort
{
	@Override
	public int[] sort(int[] a)
	{
		int[] count = new int[100];
		for (int i = 0; i < count.length; i++)
		{
			count[i] = 0;
		}
		for (int i = 0; i < a.length; i++)
		{
			count[a[i]]++;
		}
		int i = 0;
		int j = 0;
		while (i < a.length)
		{
			while (count[j] > 0)
			{
				a[i++] = j;
				count[j]--;
			}
			j++;
		}
		return a;
	}

}
