package adt.linkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

	private LinkedList<Integer> lista1;
	private LinkedList<Integer> lista2;
	private LinkedList<Integer> lista3;
	private LinkedList<Integer> lista4;
	
	@Before
	public void init() {
		this.lista1 = new SingleLinkedListImpl<Integer>();
		this.lista2 = new SingleLinkedListImpl<Integer>();
		this.lista3 = new SingleLinkedListImpl<Integer>();
		this.lista4 = new SingleLinkedListImpl<Integer>();
		
		this.lista1.insert(0);
		this.lista1.insert(1);
		this.lista1.insert(2);
		this.lista1.insert(3);
		this.lista1.insert(4);
		
		this.lista2.insert(0);
		this.lista2.insert(1);
		this.lista2.insert(2);
		this.lista2.insert(3);
		
		this.lista3.insert(0);
	}
	
	
	@Test
	public void teste01() {
		assertSame(5, this.lista1.size());
	}
	
	@Test
	public void teste02() {
		assertSame(4, this.lista2.size());
	}
	
	@Test
	public void teste03() {
		assertSame(1, this.lista3.size());
	}
	
	@Test
	public void teste04() {
		assertSame(0, this.lista4.size());
	}
	
	@Test
	public void teste05() {
		this.lista1.insert(5);
		assertSame(6, this.lista1.size());
	}
	
	@Test
	public void teste06() {
		this.lista2.insert(4);
		assertSame(5, this.lista2.size());
	}
	
	@Test
	public void teste07() {
		this.lista3.insert(1);
		assertSame(2, this.lista3.size());
	}
	
	@Test
	public void teste08() {
		this.lista4.insert(0);
		assertSame(1, this.lista4.size());
	}
	
	@Test
	public void teste09() {
		this.lista1.remove(4);
		assertSame(4, this.lista1.size());
	}
	
	@Test
	public void teste10() {
		this.lista2.remove(3);
		assertSame(3, this.lista2.size());
	}
	
	@Test
	public void teste11() {
		this.lista3.remove(0);
		assertSame(0, this.lista3.size());
	}
	
	@Test
	public void teste12() {
		this.lista4.remove(0);
		assertSame(0, this.lista4.size());
	}
	
	@Test
	public void teste13() {
		this.lista1.remove(0);
		assertSame(4, this.lista1.size());
	}
	
	@Test
	public void teste14() {
		this.lista2.remove(0);
		assertSame(3, this.lista2.size());
	}
	
	@Test
	public void teste15() {
		this.lista3.remove(0);
		assertSame(0, this.lista3.size());
	}
	
	@Test
	public void teste16() {
		this.lista4.remove(0);
		assertSame(0, this.lista4.size());
	}
	
	@Test 
	public void teste17() {
		assertFalse(this.lista1.isEmpty());
	}
	
	@Test 
	public void teste18() {
		assertFalse(this.lista2.isEmpty());
	}
	
	@Test 
	public void teste19() {
		assertFalse(this.lista3.isEmpty());
	}
	
	@Test 
	public void teste20() {
		assertTrue(this.lista4.isEmpty());
	}
	
	@Test
	public void teste21() {
		this.lista1.remove(0);
		this.lista1.remove(1);
		this.lista1.remove(2);
		this.lista1.remove(3);
		this.lista1.remove(4);
		assertTrue(this.lista1.isEmpty());
	}

	@Test
	public void teste22() {
		this.lista2.remove(0);
		this.lista2.remove(1);
		this.lista2.remove(2);
		this.lista2.remove(3);
		assertTrue(this.lista2.isEmpty());
	}
	
	@Test
	public void teste23() {
		this.lista3.remove(0);
		assertTrue(this.lista3.isEmpty());
	}
	
	@Test
	public void teste24() {
		this.lista4.remove(0);
		assertTrue(this.lista4.isEmpty());
	}
	
	@Test 
	public void teste25() {
		assertSame(3, this.lista1.search(3));
	}
	
	@Test 
	public void teste26() {
		assertSame(2, this.lista2.search(2));
	}
	
	@Test 
	public void teste27() {
		assertSame(0, this.lista3.search(0));
	}
	
	@Test 
	public void teste28() {
		assertSame(null, this.lista4.search(0));
	}
	
	@Test 
	public void teste29() {
		assertSame(0, this.lista1.search(0));
	}
	
	@Test 
	public void teste30() {
		assertSame(0, this.lista2.search(0));
	}
	
	@Test 
	public void teste31() {
		assertSame(4, this.lista1.search(4));
	}
	
	@Test 
	public void teste32() {
		assertSame(3, this.lista2.search(3));
	}
	
	@Test
	public void teste33() {
		assertArrayEquals(new Integer[] {0,1,2,3,4}, this.lista1.toArray());
	}
	
	@Test
	public void teste34() {
		assertArrayEquals(new Integer[] {0,1,2,3}, this.lista2.toArray());
	}
	
	@Test
	public void teste35() {
		assertArrayEquals(new Integer[] {0}, this.lista3.toArray());
	}
	
	@Test
	public void teste36() {
		assertArrayEquals(new Integer[] {}, this.lista4.toArray());
	}
	
	@Test
	public void teste37() {
		this.lista1.remove(3);
		this.lista1.remove(6);
		this.lista1.remove(0);
		assertArrayEquals(new Integer[] {1,2,4}, this.lista1.toArray());
	}
	
	@Test
	public void teste38() {
		this.lista2.remove(3);
		this.lista2.remove(6);
		this.lista2.remove(0);
		assertArrayEquals(new Integer[] {1,2}, this.lista2.toArray());
	}
	
	@Test
	public void teste39() {
		this.lista3.remove(3);
		this.lista3.remove(6);
		this.lista3.remove(0);
		assertArrayEquals(new Integer[] {}, this.lista3.toArray());
	}
	
	@Test
	public void teste40() {
		this.lista4.remove(3);
		this.lista4.remove(6);
		this.lista4.remove(0);
		assertArrayEquals(new Integer[] {}, this.lista4.toArray());
	}
	
	@Test
	public void teste41() {
		this.lista1.insert(3);
		this.lista1.insert(6);
		this.lista1.insert(0);
		assertArrayEquals(new Integer[] {0,1,2,3,4,3,6,0}, this.lista1.toArray());
	}
	
	@Test
	public void teste42() {
		this.lista2.insert(3);
		this.lista2.insert(6);
		this.lista2.insert(0);
		assertArrayEquals(new Integer[] {0,1,2,3,3,6,0}, this.lista2.toArray());
	}
	
	@Test
	public void teste43() {
		this.lista3.insert(3);
		this.lista3.insert(6);
		this.lista3.insert(0);
		assertArrayEquals(new Integer[] {0,3,6,0}, this.lista3.toArray());
	}
	
	@Test
	public void teste44() {
		this.lista4.insert(3);
		this.lista4.insert(6);
		this.lista4.insert(0);
		assertArrayEquals(new Integer[] {3,6,0}, this.lista4.toArray());
	}
}
