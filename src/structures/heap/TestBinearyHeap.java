package structures.heap;

public class TestBinearyHeap
{
	public static void main(String[] ar)
	{
		BinaryHeap<Integer> heap = new BinaryHeap<>(30);
		for (int i = 1; i < 20; i++)
		{
			heap.insert(20 - i);
			System.out.println("Insert a value ::::" + heap);
		}
		for (int i = 0; i < 10; i++)
		{
			System.out.print("Remove minimum>>>>>");

			System.out.print(heap.removeMin() + "\t");

			System.out.println(heap);
		}
	}
}
