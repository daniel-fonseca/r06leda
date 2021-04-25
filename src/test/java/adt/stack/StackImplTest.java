package adt.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackImplTest {

	
	private Stack<Integer> stack01;
	private Stack<Integer> stack02;
	private Stack<Integer> stack03;
	private Stack<Integer> stack04;
	
	@Before
	public void init() {
		this.stack01 = new StackDoubleLinkedListImpl<Integer>(5);
		this.stack02 = new StackDoubleLinkedListImpl<Integer>(4);
		this.stack03 = new StackDoubleLinkedListImpl<Integer>(1);
		this.stack04 = new StackDoubleLinkedListImpl<Integer>(0);
	}
	
	@Test
	public void test01() throws StackOverflowException {
		this.stack01.push(0);
		this.stack01.push(1);
		this.stack01.push(2);
		this.stack01.push(3);
		this.stack01.push(4);
		
		assertSame(4, this.stack01.top());
	}

	@Test
	public void test02() throws StackOverflowException {
		this.stack02.push(0);
		this.stack02.push(1);
		this.stack02.push(2);
		this.stack02.push(3);
		
		assertSame(3, this.stack02.top());
	}
	
	@Test
	public void test03() throws StackOverflowException {
		this.stack03.push(0);
		
		assertSame(0, this.stack03.top());
	}
	
	@Test(expected=StackOverflowException.class)
	public void test04() throws StackOverflowException {
		this.stack04.push(0);
	}
	
	@Test
	public void test05() throws StackOverflowException, StackUnderflowException {
		this.stack01.push(0);
		this.stack01.push(1);
		this.stack01.push(2);
		this.stack01.push(3);
		this.stack01.push(4);
		
		this.stack01.pop();
		this.stack01.pop();
		this.stack01.pop();
		this.stack01.pop();
		this.stack01.pop();
	}

	@Test
	public void test06() throws StackOverflowException, StackUnderflowException {
		this.stack02.push(0);
		this.stack02.push(1);
		this.stack02.push(2);
		this.stack02.push(3);
		
		this.stack02.pop();
		this.stack02.pop();
		this.stack02.pop();
		this.stack02.pop();
	
	}
	
	@Test
	public void test07() throws StackOverflowException, StackUnderflowException {
		this.stack03.push(0);
		this.stack03.pop();
	}
	
	@Test
	public void test08() throws StackOverflowException, StackUnderflowException {
		this.stack01.push(0);
		this.stack01.push(1);
		this.stack01.push(2);
		this.stack01.push(3);
		this.stack01.push(4);
	}

	@Test
	public void test09() throws StackOverflowException, StackUnderflowException {
		this.stack02.push(0);
		this.stack02.push(1);
		this.stack02.push(2);
		this.stack02.push(3);
		
		assertSame(true, this.stack02.isFull());
	}
	
	@Test
	public void test10() throws StackOverflowException, StackUnderflowException {
		this.stack03.push(0);
		
		assertSame(true, this.stack03.isFull());
	}
	
	@Test
	public void test11() throws StackOverflowException, StackUnderflowException {
		this.stack01.push(0);
		this.stack01.push(1);
		this.stack01.push(2);
		this.stack01.push(3);
		this.stack01.push(4);
		
		this.stack01.pop();
		this.stack01.pop();
		this.stack01.pop();
		this.stack01.pop();
		this.stack01.pop();
		
		assertSame(true, this.stack01.isEmpty());
	}

	@Test
	public void test12() throws StackOverflowException, StackUnderflowException {
		this.stack02.push(0);
		this.stack02.push(1);
		this.stack02.push(2);
		this.stack02.push(3);
		
		this.stack02.pop();
		this.stack02.pop();
		this.stack02.pop();
		this.stack02.pop();
		
		assertSame(true, this.stack02.isEmpty());
	}
	
	@Test
	public void test13() throws StackOverflowException, StackUnderflowException {
		this.stack03.push(0);
		this.stack03.pop();
		
		assertSame(true, this.stack03.isEmpty());
	}
	
	@Test
	public void test14() throws StackOverflowException, StackUnderflowException {
		assertSame(true, this.stack01.isEmpty());
	}

	@Test
	public void test15() throws StackOverflowException, StackUnderflowException {
		assertSame(true, this.stack02.isEmpty());
	}
	
	@Test
	public void test16() throws StackOverflowException, StackUnderflowException {
		assertSame(true, this.stack03.isEmpty());
	}
	
	@Test(expected=StackUnderflowException.class)
	public void test17() throws StackOverflowException, StackUnderflowException {
		this.stack01.push(0);
		this.stack01.push(1);
		this.stack01.push(2);
		this.stack01.push(3);
		this.stack01.push(4);
		
		this.stack01.pop();
		this.stack01.pop();
		this.stack01.pop();
		this.stack01.pop();
		this.stack01.pop();
		this.stack01.pop();
	}

	@Test(expected=StackUnderflowException.class)
	public void test18() throws StackOverflowException, StackUnderflowException {
		this.stack02.push(0);
		this.stack02.push(1);
		this.stack02.push(2);
		this.stack02.push(3);
		
		this.stack02.pop();
		this.stack02.pop();
		this.stack02.pop();
		this.stack02.pop();
		this.stack02.pop();
	}
	
	@Test(expected=StackUnderflowException.class)
	public void test19() throws StackOverflowException, StackUnderflowException {
		this.stack03.push(0);
		this.stack03.pop();
		this.stack03.pop();
	}
	
	@Test
	public void test20() throws StackOverflowException, StackUnderflowException {
		this.stack01.push(0);
		this.stack01.push(1);
		this.stack01.push(2);
		this.stack01.push(3);
		this.stack01.push(4);
		
		this.stack01.pop();
		this.stack01.pop();
		
		this.stack01.push(5);
		this.stack01.push(6);
		
		this.stack01.pop();
		
		assertSame(5, this.stack01.pop());
	}
}

