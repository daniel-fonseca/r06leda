package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		if (isEmpty()) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, null, null);
			if (!newNode.isNIL()) {
				this.setHead(newNode);
				this.setLast(newNode);
			}
		} else {
			DoubleLinkedListNode<T> oldHead = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, oldHead, null);
			if (!newNode.isNIL()) {
				oldHead.setPrevious(newNode);
				this.head = newNode;
			}
		}
	}

	@Override
	public void removeFirst() {
		if (size() == 1) {
			this.setHead(null);
			this.setLast(null);
		} else if (size() > 1) {
			DoubleLinkedListNode<T> nextFromHead = (DoubleLinkedListNode<T>) this.getHead().getNext();
			nextFromHead.setPrevious(null);
			this.setHead(nextFromHead);
		}
	}

	@Override
	public void removeLast() {
		if (size() == 1) {
			removeFirst();
		} else if (size() > 1) {
			DoubleLinkedListNode<T> newLastNode = this.last.getPrevious();
			newLastNode.setNext(null);
			this.setLast(newLastNode);
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
