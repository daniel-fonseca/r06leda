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
			while (!isLastNode(nodeAux)) {
				tamanho++;
				nodeAux = nodeAux.getNext();
			}
		}
		
		return tamanho;
	}

	@Override
	public T search(T element) {
		if (this.isEmpty()) {
			return null;
		}
		T resp = null;
		SingleLinkedListNode<T> nodeAux = head;
		
		if (nodeAux.getData().equals(element)) {
			return nodeAux.getData();
		}
		
		while(!isLastNode(nodeAux)) {
			nodeAux = nodeAux.getNext();
			if (nodeAux.getData().equals(element)) {
				resp = nodeAux.data;
				break;
			}
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
				while (!isLastNode(nodeAux)) {
					nodeAux = nodeAux.getNext();
				}
				nodeAux.setNext(newNode);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (this.search(element) != null) {
			SingleLinkedListNode<T> nodeAux = head;
			SingleLinkedListNode<T> elementAsNode = new SingleLinkedListNode<T>();
			elementAsNode.setData(element);
			boolean found = false;
			
			if (nodeAux.equals(elementAsNode)) {
				found = true;
				if (isLastNode(head)) {
					this.head.setData(null);
				} else {
					this.head = head.getNext();
				}
				return;
			}
			
			while (!found) {
				
				 if (nodeAux.next == null && !found) {
					break;
				}
				
				if (nodeAux.getNext().equals(elementAsNode)) {
					found = true;
					break;
				}
				
				if (!isLastNode(nodeAux)) {
					nodeAux = nodeAux.getNext();
				}
			}
			
			if (found) {
				if (nodeAux.getNext().hasNext()) {
					nodeAux.setNext(nodeAux.getNext().getNext());
				} else {
				nodeAux.setNext(null);
				}
			}
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
	
	protected boolean isLastNode(SingleLinkedListNode<T> node) {
		return node.next == null;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
