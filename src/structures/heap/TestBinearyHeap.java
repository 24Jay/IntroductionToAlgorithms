package structures.heap;

public class TestBinearyHeap
{
	public static void main(String[] ar)
	{
		BinaryHeap heap = new BinaryHeap<>(30);
		for (int i = 1; i < 20; i++)
			heap.insert(20-i);
		System.out.println(heap);
		System.out.println(heap.findMin());
	}
}
