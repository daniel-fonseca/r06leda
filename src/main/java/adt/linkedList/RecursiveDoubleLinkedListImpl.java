package adt.linkedList;

import java.util.NoSuchElementException;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}
	
	@Override
	public boolean isEmpty() {
		return (this.data == null) && (!this.hasNext()) && (!this.hasPrev());
	}
	
	@Override
	public void insertFirst(T element) {
		if (this.validaElemento(element)) {
			if (this.isEmpty()) {
				this.setData(element);
			} else {
				if (!this.hasPrev()) {
					RecursiveDoubleLinkedListImpl<T> newElement = new RecursiveDoubleLinkedListImpl<T>();
					newElement.setData(element);
					newElement.setNext(this);
					this.setPrevious(newElement);
				} else {
					this.getPrevious().insertFirst(element);
				}
			}
		}
	}

	@Override
	public void removeFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		if (!this.hasPrev()) {
			if (this.hasNext()) {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
			} else {
				this.setData(null);
			}
		} else {
			this.getPrevious().removeFirst();
		}
	}

	@Override
	public void removeLast() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		if (!this.hasNext()) {
			if (this.hasPrev()) {
				this.getPrevious().setNext(null);
			} else {
				this.setData(null);
			}
		} else {
			RecursiveDoubleLinkedListImpl<T> myNextDouble = new RecursiveDoubleLinkedListImpl<T>();
			myNextDouble.setData(this.getNext().getData());
			myNextDouble.setNext(this.getNext().getNext());
			myNextDouble.setPrevious(this);
			this.setNext(myNextDouble);
			myNextDouble.removeLast();
		}
	}
	
	@Override
	public int size() {
		int size = 0;
		if (!this.hasPrev()) {
			size = super.size();
		} else {
			size = this.getPrevious().size();
		}
		
		return size;
	}
	
	@Override
	public T[] toArray() {
		T[] resp = (T[]) new Object[this.size()];
		if (!this.hasPrev()) {
			resp = super.toArray();
		} else {
			resp = this.getPrevious().toArray();
		}
		
		return resp;
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}
	
	public boolean hasPrev() {
		return this.previous != null;
	}
	
	private boolean validaElemento(T element) {
		return element != null;
	}
	
}
