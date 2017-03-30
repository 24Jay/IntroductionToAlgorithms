package dynamic;

public class ThinkInFibonacci
{
	public static void main(String[] ar)
	{
		System.out.println(recurse(40));
		System.out.println(dynamic(40));
	}

	public static int recurse(int n)
	{
		if (n <= 1)
			return 1;
		else
			return recurse(n - 1) + recurse(n - 2);
	}

	public static int dynamic(int n)
	{
		if (n <= 1)
			return 1;

		int last = 1;
		int lastTolast = 1;

		int answer = 1;

		for (int i = 2; i <= n; i++)
		{
			answer = last + lastTolast;
			lastTolast = last;
			last = answer;
		}
		return answer;
	}
}
