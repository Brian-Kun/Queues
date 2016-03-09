package structures;

import java.util.NoSuchElementException;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> {
	
	Node<T> head = null;
	int size = 0;


	public T pop() throws NoSuchElementException {
		if(!this.isEmpty()){
			T answer = this.head.getData();
			this.head = head.getNext();
			size--;
			return answer;
		} else {
			throw new NoSuchElementException("pop from empty");
		}
	}


	public T top() throws NoSuchElementException {
		if(!this.isEmpty()){
			return this.head.getData();
		}else{
			throw new NoSuchElementException();
		}
		
	}


	public boolean isEmpty() {
		return (head == null);
	}

	public int size() {
		return size;
	}

	
	public void push(T elem) {
		Node<T> newNode = new Node<T>(elem);
		newNode.setNext(head);
		head = newNode;
		size++;
		
	}

}
