package sort.nn;

import sort.inf.ISort;

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
