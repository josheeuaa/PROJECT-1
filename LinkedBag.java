import java.util.Arrays;

public class LinkedBag<T> implements BagInterface<T> {
    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry, firstNode);
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
    public T remove() {
        if (firstNode != null) {
            T data = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
            return data;
        }
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        Node currentNode = firstNode;
        Node previousNode = null;

        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                if (previousNode == null) {
                    firstNode = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                numberOfEntries--;
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        Node currentNode = firstNode;

        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                count++;
            }
            currentNode = currentNode.next;
        }
        return count;
    }

    @Override
    public boolean contains(T anEntry) {
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) java.lang.reflect.Array.newInstance(firstNode.data.getClass(), numberOfEntries);
	
		int index = 0;
		Node currentNode = firstNode;
		while (currentNode != null) {
			result[index++] = currentNode.data;
			currentNode = currentNode.next;
		}
		return result;
	}
	
	@Override
public BagInterface<T> union(BagInterface<T> anotherBag) {
    LinkedBag<T> result = new LinkedBag<>();

    for (T item : this.toArray()) {
        result.add(item);
    }

    for (T item : anotherBag.toArray()) {
        result.add(item);
    }

    return result;
}

@Override
public BagInterface<T> intersection(BagInterface<T> anotherBag) {
    LinkedBag<T> result = new LinkedBag<>();
    LinkedBag<T> tempBag = new LinkedBag<>();

    for (T item : anotherBag.toArray()) {
        tempBag.add(item);
    }

    for (T item : this.toArray()) {
        if (tempBag.contains(item)) {
            result.add(item);
            tempBag.remove(item);
        }
    }
    return result;
}

@Override
public BagInterface<T> difference(BagInterface<T> anotherBag) {
    LinkedBag<T> result = new LinkedBag<>();
    
    for (T item : this.toArray()) {
        result.add(item);
    }

    for (T item : anotherBag.toArray()) {
        result.remove(item);
    }
    
    return result;
}
}
