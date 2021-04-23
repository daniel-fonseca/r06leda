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
			if (!hasOnlyDoubleNodes()) {
				convertNodes();
			}
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
			if (!hasOnlyDoubleNodes()) {
				convertNodes();
			}
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
			if (!hasOnlyDoubleNodes()) {
				convertNodes();
			}
			DoubleLinkedListNode<T> newLastNode = this.last.getPrevious();
			newLastNode.setNext(null);
			this.setLast(newLastNode);
		}
	}
	
	private void convertNodes() {
		T[] values = super.toArray();
		DoubleLinkedListNode<T>[] nodes = new DoubleLinkedListNode[values.length];
		if (this.size() == 1) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(this.getHead().getData(), null, null);
			this.setHead(newNode);
			this.setLast(newNode);
		}
		
		else if (this.size() > 1) {
			for (int i = 0; i < values.length; i++) {
				nodes[i] = new DoubleLinkedListNode<T>(values[i], null, null);
			}
				
			for (int i = 0; i < nodes.length - 1; i++) {
				nodes[i].setNext(nodes[i+1]);
				nodes[i+1].setPrevious(nodes[i]);
			}
			
			this.setHead(nodes[0]);
			this.setLast(nodes[nodes.length - 1]);
		}
	}
	
	private boolean hasOnlyDoubleNodes() {
		return (this.getHead() instanceof DoubleLinkedListNode) && (this.getLast() instanceof DoubleLinkedListNode);
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
