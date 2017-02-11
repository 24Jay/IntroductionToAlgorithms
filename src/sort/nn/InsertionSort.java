package sort.nn;

import sort.inf.ISort;

/**
 * 插入排序： 假设0...p-1是已经排序过的，将p和前面的逐个对比，插入到合适的位置
 * 
 * @author jay
 *
 */
public class InsertionSort implements ISort
{

	@Override
	public int[] sort(int[] a)
	{
		/**
		 * 假设0...p-1是已经排序好的序列[从小到大]
		 */
		for (int p = 1; p < a.length; p++)
		{
			/**
			 * 从p-1开始往前面比较，找到p的合适的位置
			 */
			int temp = a[p], i = p - 1;
			for (; i >= 0 && a[i] > temp; i--)
			{
				a[i + 1] = a[i];
			}
			a[i + 1] = temp;
		}
		return a;
	}

}
