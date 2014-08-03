
public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0; 

	protected MyAbstractList() {}

	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	public void add(E e) {
		add(size, e);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean remove(E e) {
		int index = indexOf(e);
		if (index >= 0) {
			remove(index);
			return true;
		} else
			return false;
	}
}
