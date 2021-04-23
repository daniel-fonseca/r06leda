package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return (this.data == null) && (!this.hasNext());
	}

	@Override
	public int size() {
		return size(0);
	}
	
	private int size(int sizeAtual) {
		if (!this.isNull()) {
			sizeAtual++;
			if (this.hasNext()) {
				sizeAtual = this.next.size(sizeAtual);
			}
		} else {
			sizeAtual = 0;
		}
		return sizeAtual;
	}

	@Override
	public T search(T element) {
		T resp = null;
		if (this.data.equals(element)) {
			resp = this.data;
		} else if (this.hasNext()) {
			resp = this.next.search(element);
		}
		
		return resp;
	}

	@Override
	public void insert(T element) {
		if (this.isNull()) {
			if (element != null) {
				this.setData(element);
			}
		} else {
			RecursiveSingleLinkedListImpl<T> newListElement = new RecursiveSingleLinkedListImpl<T>();
			newListElement.setData(element);
			if (!newListElement.isNull()) {
				insert(newListElement);
			}
		}
	}
	
	private void insert(RecursiveSingleLinkedListImpl<T> newListElement) {
		if (!this.hasNext()) {
			this.setNext(newListElement);
			return;
		}
		
		this.getNext().insert(newListElement);
	}

	@Override
	public void remove(T element) {
		if (this.search(element) != null) {
			if (this.getData().equals(element)) {
				if (this.hasNext()) {
					this.setData(this.next.data);
					this.setNext(this.next.next);
				} else {
					this.setData(null);
				}
			} else if (this.next.getData().equals(element)) {
				this.setNext(null);
				
			} else {
				if (this.hasNext()) {
					this.next.remove(element);
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = toArray((T[]) new Object[this.size()], 0);
		return array;
	}
	
	private T[] toArray(T[] array, int cont) {
		if (!(array.length == 0)) {
			if (!this.isNull()) {
				array[cont] = this.data;
				cont++;
				if (this.hasNext()) {
					this.next.toArray(array, cont);
				}
			}
		}
		
		return array;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
	
	private boolean hasNext() {
		return this.next != null;
	}
	
	private boolean isNull() {
		return this.data == null;
	}

}
