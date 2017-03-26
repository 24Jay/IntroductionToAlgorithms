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
		heaps[0] = 0;
	}

	public BinaryHeap(int initialCapacity)
	{
		this.currentSize = 0;
		this.heaps = new Object[initialCapacity];
		heaps[0] = 0;
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

		heaps[++currentSize] = x;
		for (int hole = currentSize; hole > 1; hole /= 2)
		{
			T a = (T) heaps[hole];
			T b = (T) heaps[hole / 2];
			if (a.compareTo(b) < 0)
			{
				heaps[hole] = b;
				heaps[hole / 2] = a;
			}
		}
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

		int hole = ++currentSize;
		heaps[currentSize] = x;
		for (; hole > 1 && x.compareTo((T) heaps[hole / 2]) < 0; hole /= 2)
		{
			heaps[hole] = heaps[hole / 2];
		}
		heaps[hole] = x;
	}

	public boolean isEmpty()
	{
		return currentSize == 1;
	}

	public T findMin()
	{
		if (!isEmpty())
			return (T) heaps[1];
		else
			return null;
	}

	/*
	 * public T removeMinimum() { if (isEmpty()) throw new
	 * ArrayIndexOutOfBoundsException();
	 * 
	 * T min = (T) heaps[1]; for (int loc = 1; 2 * loc <= currentSize;) { int
	 * nextLoc = ((T) heaps[loc * 2]).compareTo((T) heaps[loc * 2 + 1]) < 0 ?
	 * (loc * 2) : (loc * 2 + 1); heaps[loc] = nextLoc; } }
	 */

	public T removeMin()
	{
		if (isEmpty())
			throw new ArrayIndexOutOfBoundsException();

		T min = (T) heaps[1];
		heaps[1] = heaps[currentSize];
		heaps[currentSize--] = null;
		percolateDown(1);
		return min;
	}

	private void percolateDown(int hole)
	{
		int child;
		T temp = (T) heaps[hole];
		for (; hole * 2 <= currentSize; hole = child)
		{
			child = hole * 2;
			if (child != currentSize && ((T) heaps[child + 1]).compareTo((T) heaps[child]) < 0)
				child++;
			if (((T) heaps[child]).compareTo(temp) < 0)
				heaps[hole] = heaps[child];
			else
			{
				break;
			}
		}
		heaps[hole] = temp;
	}

	public String toString()
	{
		return Arrays.toString(heaps);
	}
}
