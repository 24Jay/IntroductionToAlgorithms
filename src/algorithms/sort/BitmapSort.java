package algorithms.sort;

import java.util.BitSet;

import algorithms.sort.inf.ISort;

/**
 * 基本原理就是与桶排序类似，可以应用于数据量很大的应用,但是针对重复的数据会有问题
 * 
 * @author jay
 *
 */
public class BitmapSort implements ISort
{

	@Override
	public int[] sort(int[] a)
	{
		BitSet bits = new BitSet();
		// 初始化bitset
		for (int i = 0; i < 101; i++)
			bits.set(i, false);

		//遍历０－１００，将有a[i]对应的值设置为true,并且去除重复，统计个数
		int count = 0;
		for (int j = 0; j < a.length; j++)
		{
			if (!bits.get(a[j]))
			{
				bits.set(a[j], true);
				count++;
			}
		}
		int[] b = new int[count];
		for (int i = 0, k=0; i < 101; i++)
		{
			if (bits.get(i))
				b[k++]=i;
		}
		return b;
	}

}
