package adt.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.stack.StackOverflowException;

public class QueueImplTest {

	private Queue<Integer> queue01;
	private Queue<Integer> queue02;
	private Queue<Integer> queue03;
	private Queue<Integer> queue04;
	
	@Before
	public void init() {
		this.queue01 = new QueueDoubleLinkedListImpl<Integer>(5);
		this.queue02 = new QueueDoubleLinkedListImpl<Integer>(4);
		this.queue03 = new QueueDoubleLinkedListImpl<Integer>(1);
		this.queue04 = new QueueDoubleLinkedListImpl<Integer>(0);
	}
	
	@Test
	public void test01() throws QueueOverflowException {
		this.queue01.enqueue(0);
		this.queue01.enqueue(1);
		this.queue01.enqueue(2);
		this.queue01.enqueue(3);
		this.queue01.enqueue(4);
		
		assertSame(this.queue01.head(), 0);
		
	}
	
	@Test
	public void test02() throws QueueOverflowException {
		this.queue02.enqueue(0);
		this.queue02.enqueue(1);
		this.queue02.enqueue(2);
		this.queue02.enqueue(3);
		
		assertSame(this.queue02.head(), 0);
	}

	@Test
	public void test03() throws QueueOverflowException {
		this.queue03.enqueue(0);
		
		assertSame(this.queue03.head(), 0);
	}
	
	@Test(expected=QueueOverflowException.class)
	public void test04() throws QueueOverflowException {
		this.queue04.enqueue(0);
	}
	
	@Test
	public void test05() throws QueueOverflowException, QueueUnderflowException {
		this.queue01.enqueue(0);
		this.queue01.enqueue(1);
		this.queue01.enqueue(2);
		this.queue01.enqueue(3);
		this.queue01.enqueue(4);
		
		this.queue01.dequeue();
		this.queue01.dequeue();
		this.queue01.dequeue();
		this.queue01.dequeue();
		this.queue01.dequeue();
		
		assertSame(this.queue01.head(), null);
	}
	
	@Test
	public void test06() throws QueueOverflowException, QueueUnderflowException {
		this.queue02.enqueue(0);
		this.queue02.enqueue(1);
		this.queue02.enqueue(2);
		this.queue02.enqueue(3);
		
		this.queue02.dequeue();
		this.queue02.dequeue();
		this.queue02.dequeue();
		this.queue02.dequeue();
		
		
		assertSame(this.queue02.head(), null);
	}

	@Test
	public void test07() throws QueueOverflowException, QueueUnderflowException {
		this.queue03.enqueue(0);
		this.queue03.dequeue();
		
		assertSame(this.queue03.head(), null);
	}
	
	@Test(expected=QueueUnderflowException.class)
	public void test08() throws QueueOverflowException, QueueUnderflowException {
		this.queue01.enqueue(0);
		this.queue01.enqueue(1);
		this.queue01.enqueue(2);
		this.queue01.enqueue(3);
		this.queue01.enqueue(4);
		
		this.queue01.dequeue();
		this.queue01.dequeue();
		this.queue01.dequeue();
		this.queue01.dequeue();
		this.queue01.dequeue();
		
		this.queue01.dequeue();
	}
	
	@Test(expected=QueueUnderflowException.class)
	public void test09() throws QueueOverflowException, QueueUnderflowException {
		this.queue02.enqueue(0);
		this.queue02.enqueue(1);
		this.queue02.enqueue(2);
		this.queue02.enqueue(3);
		
		this.queue02.dequeue();
		this.queue02.dequeue();
		this.queue02.dequeue();
		this.queue02.dequeue();
		
		this.queue02.dequeue();
	}

	@Test(expected=QueueUnderflowException.class)
	public void test10() throws QueueOverflowException, QueueUnderflowException {
		this.queue03.enqueue(0);
		this.queue03.dequeue();
		
		this.queue03.dequeue();
	}
	
	@Test
	public void test11() throws QueueOverflowException, QueueUnderflowException {
		this.queue01.enqueue(0);
		this.queue01.enqueue(1);
		this.queue01.enqueue(2);
		this.queue01.enqueue(3);
		this.queue01.enqueue(4);
		
		this.queue01.dequeue();
		this.queue01.dequeue();
		this.queue01.dequeue();
		this.queue01.dequeue();
		this.queue01.dequeue();
		
		assertSame(this.queue01.isEmpty(), true);
	}
	
	@Test
	public void test12() throws QueueOverflowException, QueueUnderflowException {
		this.queue02.enqueue(0);
		this.queue02.enqueue(1);
		this.queue02.enqueue(2);
		this.queue02.enqueue(3);
		
		this.queue02.dequeue();
		this.queue02.dequeue();
		this.queue02.dequeue();
		this.queue02.dequeue();
		
		
		assertSame(this.queue02.isEmpty(), true);
	}

	@Test
	public void test13() throws QueueOverflowException, QueueUnderflowException {
		this.queue03.enqueue(0);
		this.queue03.dequeue();
		
		assertSame(this.queue03.isEmpty(), true);
	}
	
	@Test
	public void test14() throws QueueOverflowException, QueueUnderflowException {
		this.queue01.enqueue(0);
		this.queue01.enqueue(1);
		this.queue01.enqueue(2);
		this.queue01.enqueue(3);
		this.queue01.enqueue(4);
		
		this.queue01.dequeue();
		this.queue01.dequeue();
		this.queue01.dequeue();
		this.queue01.dequeue();
		
		assertSame(this.queue01.isEmpty(), false);
	}
	
	@Test
	public void test15() throws QueueOverflowException, QueueUnderflowException {
		this.queue02.enqueue(0);
		this.queue02.enqueue(1);
		this.queue02.enqueue(2);
		this.queue02.enqueue(3);
		
		this.queue02.dequeue();
		this.queue02.dequeue();
		this.queue02.dequeue();
		
		
		assertSame(this.queue02.isEmpty(), false);
	}

	@Test
	public void test16() throws QueueOverflowException, QueueUnderflowException {
		this.queue03.enqueue(0);
		
		assertSame(this.queue03.isEmpty(), false);
	}
	
	@Test
	public void test17() throws QueueOverflowException, QueueUnderflowException {
		this.queue01.enqueue(0);
		this.queue01.enqueue(1);
		this.queue01.enqueue(2);
		this.queue01.enqueue(3);
		this.queue01.enqueue(4);
		
		assertSame(this.queue01.isFull(), true);
	}
	
	@Test
	public void test18() throws QueueOverflowException, QueueUnderflowException {
		this.queue02.enqueue(0);
		this.queue02.enqueue(1);
		this.queue02.enqueue(2);
		this.queue02.enqueue(3);		
		
		assertSame(this.queue02.isFull(), true);
	}

	@Test
	public void test19() throws QueueOverflowException, QueueUnderflowException {
		this.queue03.enqueue(0);
		
		assertSame(this.queue03.isFull(), true);
	}
	
	@Test
	public void test20() throws QueueOverflowException, QueueUnderflowException {
		this.queue01.enqueue(0);
		this.queue01.enqueue(1);
		this.queue01.enqueue(2);
		this.queue01.enqueue(3);
		
		assertSame(this.queue01.isFull(), false);
	}
	
	@Test
	public void test21() throws QueueOverflowException, QueueUnderflowException {
		this.queue02.enqueue(0);
		this.queue02.enqueue(1);
		this.queue02.enqueue(2);
		
		assertSame(this.queue02.isFull(), false);
	}

	@Test
	public void test22() throws QueueOverflowException, QueueUnderflowException {
		assertSame(this.queue03.isFull(), false);
	}
	
	@Test
	public void test23() throws QueueOverflowException, QueueUnderflowException {
		assertSame(this.queue01.isFull(), false);
	}
	
	@Test
	public void test24() throws QueueOverflowException, QueueUnderflowException {
		assertSame(this.queue02.isFull(), false);
	}
	
	@Test
	public void test25() throws QueueOverflowException, QueueUnderflowException {
		this.queue01.enqueue(0);
		this.queue01.enqueue(1);
		this.queue01.enqueue(2);
		this.queue01.dequeue();
		
		assertSame(this.queue01.head(), 1);
	}
	
	@Test
	public void test26() throws QueueOverflowException, QueueUnderflowException {
		this.queue02.enqueue(0);
		this.queue02.enqueue(1);
		this.queue02.enqueue(2);
		this.queue02.dequeue();
		
		assertSame(this.queue02.head(), 1);
	}
	
	@Test
	public void test27() throws QueueOverflowException, QueueUnderflowException {
		this.queue03.enqueue(0);
		this.queue03.dequeue();
		
		assertSame(this.queue01.head(), null);
	}
	

	@Test
	public void test28() throws QueueOverflowException, QueueUnderflowException {
		this.queue01.enqueue(0);
		this.queue01.enqueue(1);
		this.queue01.enqueue(3);
		
		this.queue01.dequeue();
		this.queue01.dequeue();
		
		this.queue01.enqueue(4);
		this.queue01.enqueue(5);
		
		this.queue01.dequeue();
		this.queue01.dequeue();
		this.queue01.dequeue();
		
		this.queue01.enqueue(6);
		this.queue01.enqueue(7);
		this.queue01.enqueue(8);
		
		assertSame(6, this.queue01.dequeue());
		
	}
	
	@Test
	public void test29() throws QueueOverflowException, QueueUnderflowException {
		this.queue02.enqueue(0);
		this.queue02.enqueue(1);
		this.queue02.enqueue(3);
		
		this.queue02.dequeue();
		this.queue02.dequeue();
		
		this.queue02.enqueue(4);
		this.queue02.enqueue(5);
		
		this.queue02.dequeue();
		this.queue02.dequeue();
		this.queue02.dequeue();
		
		this.queue02.enqueue(6);
		this.queue02.enqueue(7);
		this.queue02.enqueue(8);
		
		assertSame(6, this.queue02.dequeue());
	}
}
