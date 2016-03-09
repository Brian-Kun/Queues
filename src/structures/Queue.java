package structures;

import java.util.NoSuchElementException;

public class Queue<T> implements UnboundedQueueInterface<T> {
	
	Node<T> head;
	Node<T> tail;
	
	int size;
	
	public Queue() {
		// TODO 1
		head = null;
		tail = null;
	}
	
	public Queue(Queue<T> other) {
		
		int size = other.size();
		
		for(int i = 0; i < size; i ++){
			this.enqueue(other.getElementAt(i));
		}
		
	}
	
	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void enqueue(T element) {
		Node<T> newNode = new Node<T>(element);
		if(tail == null)
			head = newNode;
		else
			tail.setNext(newNode);
		tail = newNode;
		size++;
		
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		if(head == null)
			throw new NoSuchElementException("it's empty man!");
		T answer = head.getData();
		head = head.getNext();
		if(head == null) tail = null;
		size--;
		return answer;
		
	}

	@Override
	public T peek() throws NoSuchElementException {
		if(head == null)
			throw new NoSuchElementException("it's empty man!");
		return head.getData();
	}

	@Override
	public UnboundedQueueInterface<T> reversed() {
		//1. Dequeue all the elements of the queue into a stack
		//2.Create a new queue and enqueue all the elements from the stack into it 
		
		Queue<T> thisQueue = new Queue<T>(this); 
		System.out.println(thisQueue.size());
		
		LinkedStack<T> stack = new LinkedStack<T>();
		
		int queueSize = thisQueue.size;
		for(int i = 0; i < queueSize; i++){
			stack.push(thisQueue.dequeue());
		}
		
		
		Queue<T> answer = new Queue<T>();
		for(int i = 0; i < queueSize; i++){
			answer.enqueue(stack.pop());
		}
		return answer;
	}
	
	public T getElementAt(int n) throws NoSuchElementException{
		Node<T> currNode = head;
		int size = this.size;
		if(n > size)
			throw new NoSuchElementException();
		for(int i = 0; i <= n; i++){
			if(i == n)
				return currNode.getData();
			currNode = currNode.getNext();
		}
		
		
		return null;
	}
}
