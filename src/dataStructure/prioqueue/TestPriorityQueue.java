package dataStructure.prioqueue;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TestPriorityQueue
{
	public static void main(String[] ra)
	{
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(12);
		for (int i = 12; i > 0; i--)
			queue.add(i);

		for (int i = 0; i < 12; i++)
			System.out.println(queue.poll());
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		int a = (1+Integer.MAX_VALUE)/2;
		
		//signed shift right
		int b = (1+Integer.MAX_VALUE)>>1;
		
		//unsigned shift right
		int c = (1+Integer.MAX_VALUE)>>>1;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
