package sort;

public class MergeSort implements ISort
{

	@Override
	public int[] sort(int[] a)
	{
		divide(a, 0, a.length - 1);
		return a;
	}

	private void divide(int[] a, int low, int high)
	{
		int mid = (low + high) / 2;
		System.out.println("low=" + low + ", high=" + high);

		divide(a, low, mid);
		divide(a, mid + 1, high);
		mg(a, low, mid, high);
	}

	private void mg(int[] a, int low, int mid, int high)
	{
		int[] c = new int[mid - low + 1];
		int[] d = new int[high - mid];
		int j = 0, k = 0;
		for (int i = 0; i < c.length; i++)
			c[i] = a[low + i];

		for (int i = 0; i < d.length; i++)
			d[i] = a[mid + 1 + i];

		while (j < c.length && k < d.length)
		{
			if (c[j] < d[k])
				a[low + j + k] = a[j++];
			else
				a[low + j + k] = d[k++];
		}
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
