package search;

import java.util.Arrays;

/**
 * 给一个数组，从中找出第Ｋ小的那个
 * 
 * @author jay
 *
 */
public class FindKth
{
	public static void main(String[] ar)
	{
		int[] a =
			{ 23, 22, 5, 56, 44, 3, 21, 23, 58, 14, 9, 10, 9, 56, 89, 51, 74, 76, 78, 66 };
		System.out.println(findKth(1,a));
		System.out.println(findKth(2,a));
		System.out.println(findKth(3,a));
		System.out.println(findKth(4,a));
		System.out.println(findKth(5,a));
		System.out.println(findKth(6,a));

		
	}

	private static int findKth(int k, int[] a)
	{
		int[] b = Arrays.copyOfRange(a, 0, k);
		Arrays.sort(b);
//		System.out.println(Arrays.toString(b));

		for (int i = k; i < a.length; i++)
		{
			
			//如果a[i]比最大的那个还大，那么跳过这个数
			if(a[i] >= b[k-1])
				continue;
			
			int temp = a[i], j = k - 1;
			while (j >= 0 && b[j] > a[i])
			{
				if (j == k - 1)
					b[j] = temp;
				else
					b[j + 1] = b[j];
				j--;
			}
			b[j+1] = temp;
		}
		return b[k - 1];
	}
}
