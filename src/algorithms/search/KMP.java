package algorithms.search;

import java.util.Arrays;

/**
 * KMP字符串匹配算法
 * 
 * @author jay
 *
 */
public class KMP
{
	public static void main(String[] ar)
	{
		System.out.println("basic method : "+new KMP().basic("zhangjjjzhng", "zhn"));
		System.out.println("KMP method : "+new KMP().kmp("zhangjjjzhng", "zhn"));
	}

	/**
	 * 从
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int basic(String target, String pattern)
	{
		for (int i = 0; i < target.length() - pattern.length(); i++)
		{
			int j = 0;
			for (; j < pattern.length(); j++)
			{
				if (target.charAt(i + j) != pattern.charAt(j))
					break;
			}
			if (j == pattern.length())
				return ++i;
		}
		return -1;
	}

	
	/**
	 * KMP算法
	 * @param target
	 * @param pattern
	 * @return
	 */
	public int kmp(String target, String pattern)
	{
		int i = 0;
		int[] ov = overload(pattern);
		while (i < target.length() - pattern.length())
		{
			int j = 0;
			for (; j < pattern.length();)
			{
				if (target.charAt(i + j) == pattern.charAt(j))
				{
					j++;
				}
				else
				{
					/**
					 * 相当于把pattern向右移动j-ov[j]
					 */
					i += j - ov[j];
//					System.out.println("miss! i="+i);
					break;
				}
			}
			if (j == pattern.length())
				return ++i;
		}
		return -1;
	}

	private static int[] overload(String pattern)
	{
		int[] ov = new int[pattern.length()];
		for (int i = 0; i < pattern.length(); i++)
		{
			ov[i] = computeLoad(pattern.substring(0, i + 1));
		}
		System.out.println("overload function : "+Arrays.toString(ov));
		return ov;
	}

	private static int computeLoad(String pattern)
	{
		if (pattern.length() == 1 || pattern.length() == 0)
			return -1;
		int overload = -1;
		for (int i = 0; i < pattern.length() / 2; i++)
		{
			if (pattern.substring(0, i + 1)
					.equals(pattern.substring(pattern.length() - i - 1, pattern.length())))
			{
				System.out.println("Matched!");
				overload = i;
			}
		}
		return overload;
	}
}
