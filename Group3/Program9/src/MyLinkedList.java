import java.util.Comparator;

public class MyLinkedList<E> extends MyAbstractList<E>{
	private Node<E> head, tail;

	public MyLinkedList() {
	}

	public MyLinkedList(E[] objects) {
		super(objects);
	}

	public E getFirst() {
		if (size == 0) {
			return null;
		} else {
			return head.element;
		}
	}

	public E getLast() {
		if (size == 0) {
			return null;
		} else {
			return tail.element;
		}
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e);
		newNode.next = head; 
		head = newNode; 
		size++; 

		if (tail == null){
			tail = head;
		}		
	}

	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e); 

		if (tail == null) {
			head = tail = newNode; 
		} else {
			tail.next = newNode; 
			tail = tail.next;
		}
		size++; 
	}

	public void add(int index, E e) {
		if (index == 0) {
			addFirst(e);
		} else if (index >= size) {
			addLast(e);
		} else {
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
		}
	}

	public E removeFirst() {
		if (size == 0) {
			return null;
		} else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null) {
				tail = null;
			}
			return temp.element;
		}
	}

	public E removeLast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E> current = head;

			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}

			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	public E remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}

			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", "); // Separate two elements with a comma
			}
		}
		
		result.append("]");

		return result.toString();
	}

	public void clear() {
		head = tail = null;
	}
	
	public MyLinkedList<E> split(int index) {
		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			MyLinkedList<E> newList = new MyLinkedList<E>();
			newList.head = head;
			newList.tail = tail;
			newList.size = size;
			
			tail = null;
			head = null;
			size = 0;
			
			return newList;
		} else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}
			
			// Create a new list to return
			MyLinkedList<E> newList = new MyLinkedList<E>();
			newList.head = previous.next;
			newList.tail = tail;
			tail = previous;
			previous.next = null;
			newList.size = size - index;
			size = index;

			return newList;
		}
	}

	public boolean contains(E e) {
		System.out.println("Implementation left as an exercise");
		return true;
	}
	
	public E get(int index) {
		
		if (index == size - 1) {
			return tail.element;
		}
		
		if (index >= size) {
			return null;
		}
		
		Node<E> previous = head;

		for (int i = 0; i < index; i++) {
			previous = previous.next;
		}
		
		return previous.element;
	}

	public int indexOf(E e) {
		System.out.println("Implementation left as an exercise");
		return 0;
	}

	public int lastIndexOf(E e) {
		System.out.println("Implementation left as an exercise");
		return 0;
	}

	public E set(int index, E e) {
		System.out.println("Implementation left as an exercise");
		return null;
	}
	
	public static <T> MyLinkedList<T> mergeSortedLists(MyLinkedList<T> list1, MyLinkedList<T> list2, Comparator<T> comp) {
		int current1 = 0;
		int current2 = 0;
		
		while (current1 < list1.size() && current2 < list2.size()) {
			if (comp.compare(list1.get(current1), list2.get(current2)) > 0) {
				list1.add(current1++, list2.get(current2++));
			} else {
				current1++;
			}
		}
		while (current2 < list2.size()) {
			list1.add(list2.get(current2++));
		}
		
		return list1;
	}

	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}
}
