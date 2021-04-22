package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int tamanho = 0;
		
		if (!isEmpty()) {
			SingleLinkedListNode<T> nodeAux = head;
			tamanho++;
			while (!isLastElement(nodeAux)) {
				tamanho++;
				nodeAux = nodeAux.getNext();
			}
		}
		
		return tamanho;
	}

	@Override
	public T search(T element) {
		T resp = null;
		SingleLinkedListNode<T> nodeAux = head;
		
		while(!isLastElement(nodeAux)) {
			if (nodeAux.getData().equals(element)) {
				resp = nodeAux.data;
				break;
			}
			nodeAux = nodeAux.getNext();
		}
		
		return resp;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>();
		newNode.setData(element);
		if (!newNode.isNIL()) {
			if (isEmpty()) {
				head = newNode;
			}
			else {
				SingleLinkedListNode<T> nodeAux = head;
				while (!isLastElement(nodeAux)) {
					nodeAux = nodeAux.getNext();
				}
				nodeAux.setNext(newNode);
			}
		}
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> nodeAux = head;
		SingleLinkedListNode<T> elementAsNode = new SingleLinkedListNode<T>();
		elementAsNode.setData(element);
		boolean found = false;
		
		while (!isLastElement(nodeAux)) {
			if (nodeAux.getNext().equals(elementAsNode)) {
				found = true;
				break;
			}
		}
		
		if (found) {
			nodeAux.setNext(null);
		}
	}

	@Override
	public T[] toArray() {
		int tamanho = this.size();
		T[] array = (T[]) new Object[tamanho];
		SingleLinkedListNode<T> nodeAux = head;
		for (int i = 0; i < tamanho; i++) {
			array[i] = nodeAux.getData();
			nodeAux = nodeAux.getNext();
		}
		return array;
	}
	
	private boolean isLastElement(SingleLinkedListNode<T> node) {
		return node.next == null;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
