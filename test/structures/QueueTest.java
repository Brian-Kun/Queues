package structures;

import static org.junit.Assert.*;

import org.junit.Test;


public class QueueTest {
	
	Queue<Integer> queue = new Queue<Integer>();
	
	@Test
	public void testEnqueueAndDequeu(){

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		int dequeue1 = queue.dequeue();
		int dequeue2 = queue.dequeue();
		int dequeue3 = queue.dequeue();
		int dequeue4 = queue.dequeue();
		
		assertEquals(1, dequeue1);
		assertEquals(2, dequeue2);
		assertEquals(3, dequeue3);
		assertEquals(4, dequeue4);
	}
	
	@Test
	public void testSize(){
		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size);
		
		queue.enqueue(1);
		assertEquals(1, queue.size);
		
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		assertEquals(4, queue.size);
		assertFalse(queue.isEmpty());
		
		queue.dequeue();
		assertEquals(3, queue.size);
		
		queue.dequeue();
		queue.dequeue();
		assertEquals(1, queue.size);
		
		queue.dequeue();
	}
	
	@Test 
	public void testReverse(){
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		UnboundedQueueInterface<Integer> newQueue = queue.reversed();
		
		int dequeue4 = newQueue.dequeue();
		int dequeue3 = newQueue.dequeue();
		int dequeue2 = newQueue.dequeue();
		int dequeue1 = newQueue.dequeue();
		
		assertEquals(4, dequeue4);
		assertEquals(3, dequeue3);
		assertEquals(2, dequeue2);
		assertEquals(1, dequeue1);
	}
	
	@Test
	public void testReverseModification(){
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		queue.reversed();
		
		int dequeue1 = queue.dequeue();
		assertEquals(1, dequeue1);
	}
	
	
	
	
	

}
