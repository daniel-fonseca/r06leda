package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull()) {
			throw new StackOverflowException();
		}
		top.insert(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		}
		T resp = this.top.toArray()[top.toArray().length - 1];
		top.removeLast();
		return resp;
	}

	@Override
	public T top() {
		return this.top.toArray()[this.top.toArray().length - 1];
	}

	@Override
	public boolean isEmpty() {
		return this.top.size() == 0;
	}

	@Override
	public boolean isFull() {
		return this.top.size() == size;
	}

}
