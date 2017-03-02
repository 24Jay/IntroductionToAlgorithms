package algorithms;

public class ThinkIn_RuntimeConstantPool
{
	public static void main(String[] ar)
	{
		String a = "hello";
		String b = "hello";
		String c = "hel" + new String("lo");
		final String d = "lo";
		String e = "lo";
		String f = "hel" + d;
		String g = "hel" + e;
		// + "因为它们都存在于常量池"
		System.out.println(a == b);
		// + "因为new是需要在堆里动态生成的");
		System.out.println(a != c);
		// + "因为它们都存在于常量池");
		System.out.println(d == e);

		System.out.println(f != g);
		
		System.out.println(a != f);
		
		System.out.println(a != g);
		
		System.out.println(c != g);
		
	}
}
