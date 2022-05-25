import java.util.Comparator;
import java.util.NoSuchElementException;
package Java_Projects.Bar_Profits;

public class MinPQ <Key extends Comparable<Key>>{
	private Key[] pq; 	//store items at indicies 1 to n
	private int n;		//number of items on priority queue
	private Comparator<Key> comparator;

	//empty priorirty quque with the given intial capacity
	public MinPQ(int initCapacity) {
		pq = (Key[]) new Object[initCapacity + 1];
		n = 0;
	}


	//Initializes an empty priority queue
	public MinPQ() {
		this(1);
	}

	public MinPQ(int initCapacity, Comparator<Key> comparator) {
		this.comparator = comparator;
		pq = (Key[]) new Event[initCapacity + 1];
		n = 0;
	}

	public MinPQ(Comparator<Key> comparator) {
		this(1, comparator);
	}


	//Returns true if queue is empty.
	public boolean isEmpty()
	{ return n == 0; 
	}

	//Returns the number of keys to the queue.
	public int size() {
		return n;
	}


	//Returns a smallest key to priority queue.
	public Key min() {
		if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
		return pq[1];
	}

	private void resize(int capacity) {
		assert capacity > n;
		Key[] temp = (Key[]) new Event[capacity];
		for (int i = 1; i <= n; i++) {
			temp[i] = pq[i];
		}
		pq = temp;
	}



	//Adds a new key to priority queue.
	public void insert(Key x) {

		if (n == pq.length-1) resize(2 * pq.length);

		pq[++n] = x;
		swim(n);
	}
