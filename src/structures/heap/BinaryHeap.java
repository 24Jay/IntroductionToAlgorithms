package structures.heap;

import java.util.Arrays;

public class BinaryHeap<T extends Comparable<T>>
{
	private static final int DEFAULT_CAPACITY = 10;

	private int currentSize;

	private Object[] heaps;

	public BinaryHeap()
	{
		this.currentSize = 0;
		this.heaps = new Object[DEFAULT_CAPACITY];
	}

	public BinaryHeap(int initialCapacity)
	{
		this.currentSize = 0;
		this.heaps = new Object[initialCapacity];
	}

	public BinaryHeap(Object[] items)
	{
		this.heaps = items;// new Object[items.length];
		this.currentSize = items.length;
	}

	private void enlargeArray(int size)
	{
		if (size <= heaps.length)
			return;
		heaps = Arrays.copyOf(heaps, size);
	}

	public void insert(T x)
	{
		if (currentSize == heaps.length - 1)
			enlargeArray(currentSize * 2 + 1);

		heaps[currentSize] = x;
		for (int hole = currentSize; hole > 0; hole /= 2)
		{
			T a = (T) heaps[hole];
			T b = (T) heaps[hole / 2];
			if (a.compareTo(b) < 0)
			{
				heaps[hole] = b;
				heaps[hole / 2] = a;
			}
		}
		currentSize++;
	}

	/***
	 * original insert method for <br>
	 * 
	 * @param x
	 */
	public void insertttt(T x)
	{
		if (currentSize == heaps.length - 1)
			enlargeArray(currentSize * 2 + 1);

		int hole = currentSize++;
		heaps[currentSize] = x;
		for (; hole > 0 && x.compareTo((T) heaps[hole / 2]) < 0; hole /= 2)
		{
			heaps[hole] = heaps[hole / 2];
		}
		heaps[hole] = x;
	}

	
	
	public boolean isEmpty()
	{
		return currentSize == 0;
	}

	public T findMin()
	{
		if (!isEmpty())
			return (T) heaps[0];
		else
			return null;
	}
	
	
	public T removeMin()
	{
		if(isEmpty())
			throw new ArrayIndexOutOfBoundsException();
		
		T min = (T) heaps[0];
		heaps[0] = heaps[--currentSize];
		percolateDown(0);
		return min;
	}
	
	private void percolateDown(int hole)
	{
		
	}

	public String toString()
	{
		return Arrays.toString(heaps);
	}
}
