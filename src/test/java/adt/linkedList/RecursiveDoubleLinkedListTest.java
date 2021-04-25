package adt.linkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecursiveDoubleLinkedListTest {

	private DoubleLinkedList<Integer> lista1;
	private DoubleLinkedList<Integer> lista2;
	private DoubleLinkedList<Integer> lista3;
	private DoubleLinkedList<Integer> lista4;
	
	@Before
	public void init() {
		
		this.lista1 = new RecursiveDoubleLinkedListImpl<Integer>();
		this.lista2 = new RecursiveDoubleLinkedListImpl<Integer>();
		this.lista3 = new RecursiveDoubleLinkedListImpl<Integer>();
		this.lista4 = new RecursiveDoubleLinkedListImpl<Integer>();
	
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
	
	@Test
	public void teste45() {
		this.lista1.insertFirst(6);
		assertArrayEquals(new Integer[] {6,0,1,2,3,4}, this.lista1.toArray());
	}
	
	@Test
	public void teste46() {
		this.lista2.insertFirst(6);
		assertArrayEquals(new Integer[] {6,0,1,2,3}, this.lista2.toArray());
	}
	
	@Test
	public void teste47() {
		this.lista3.insertFirst(6);
		assertArrayEquals(new Integer[] {6,0}, this.lista3.toArray());
	}
	
	@Test
	public void teste48() {
		this.lista4.insertFirst(6);
		assertArrayEquals(new Integer[] {6}, this.lista4.toArray());
	}
	
	@Test
	public void teste49() {
		this.lista1.removeFirst();
		assertArrayEquals(new Integer[] {1,2,3,4}, this.lista1.toArray());
	}
	
	@Test
	public void teste50() {
		this.lista2.removeFirst();
		assertArrayEquals(new Integer[] {1,2,3}, this.lista2.toArray());
	}
	
	@Test
	public void teste51() {
		this.lista3.removeFirst();
		assertArrayEquals(new Integer[] {}, this.lista3.toArray());
	}
	
	@Test
	public void teste53() {
		this.lista1.removeFirst();
		assertSame(4, this.lista1.size());
	}
	
	@Test
	public void teste54() {
		this.lista2.removeFirst();
		assertSame(3, this.lista2.size());
	}
	
	@Test
	public void teste55() {
		this.lista3.removeFirst();
		assertSame(0, this.lista3.size());
	}

	@Test
	public void teste57() {
		this.lista1.removeLast();
		assertArrayEquals(new Integer[] {0,1,2,3}, this.lista1.toArray());
	}
	
	@Test
	public void teste58() {
		this.lista2.removeLast();
		assertArrayEquals(new Integer[] {0,1,2}, this.lista2.toArray());
	}
	
	@Test
	public void teste59() {
		this.lista3.removeLast();
		assertArrayEquals(new Integer[] {}, this.lista3.toArray());
	}
	
	@Test
	public void teste61() {
		this.lista1.removeLast();
		assertSame(4, this.lista1.size());
	}
	
	@Test
	public void teste62() {
		this.lista2.removeLast();
		assertSame(3, this.lista2.size());
	}
	
	@Test
	public void teste63() {
		this.lista3.removeLast();
		assertSame(0, this.lista3.size());
	}
	
	
	@Test
	public void teste65() {
		this.lista1.insert(5);
		this.lista1.remove(0);
		this.lista1.removeFirst();
		this.lista1.insert(6);
		this.lista1.removeLast();
		
		assertArrayEquals(new Integer[] {2,3,4,5}, this.lista1.toArray());
	}
	
	@Test
	public void teste66() {
		this.lista2.insert(5);
		this.lista2.remove(0);
		this.lista2.removeFirst();
		this.lista2.insert(6);
		this.lista2.removeLast();
		
		assertArrayEquals(new Integer[] {2,3,5}, this.lista2.toArray());
	}
	
	@Test
	public void teste67() {
		this.lista3.insert(5);
		this.lista3.remove(0);
		this.lista3.removeFirst();
		this.lista3.insert(6);
		this.lista3.removeLast();
		
		assertArrayEquals(new Integer[] {}, this.lista3.toArray());
	}
	
	@Test
	public void teste68() {
		this.lista4.insert(5);
		this.lista4.remove(0);
		this.lista4.removeFirst();
		this.lista4.insert(6);
		this.lista4.removeLast();
		
		assertArrayEquals(new Integer[] {}, this.lista4.toArray());
	}
}
