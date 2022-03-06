package lab5.general;

import java.util.NoSuchElementException;

public class FIFO {

    private Node first;
    private Node last;
    private int size = 0;
    private int maxSize = 0;

    public void add(Object item) {
        Node node = new Node(item);
        if (first == null) {
            first = node;
            last = node;
        } else if (first.getNext() == null) {
            last = node;
            first.setNext(node);
        } else {
            last.setNext(node);
            last = node;
        }
        size++;
        if (size >= maxSize) {
            maxSize = size;
        }
    }

    public void removeFirst() throws NoSuchElementException {
        if (first != null) {
            this.first = first.getNext();
            size--;
        } else {
            throw new NoSuchElementException();
        }
    }

    public Object first() throws NoSuchElementException {
        if (first != null) {
            return first.getValue();
        }
        throw new NoSuchElementException();
    }

    public int maxSize() {
        return maxSize;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public boolean equals(Object f) {
        FIFO newFIFO = (FIFO) f;
        if (this.size == newFIFO.size) {
            Node fIFONode = first;
            Node fNode = newFIFO.first;
            while (fIFONode != null) {
                if (!(fIFONode.equals(fNode))) {
                    return false;
                }
                fIFONode = fIFONode.getNext();
                fNode = fNode.getNext();
            }
            return true;
        }
        return false;
    }

    public String toString() {
        Node node = first;
        String queue = "Queue: ";
        while (node != null) {
            queue = queue +"(" + node.getValue() + ") ";
            node = node.getNext();
        }
        return queue;
    }
}

class Node {

    Object value;
    private Node next;

    public Node(Object x) {
        this.value = x;
    }

    public Object getValue() {
        return value;
    }

    public void setNext(Node node) {
        next = node;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Node input) {
            if (this.value == null) {
                if(input.value == null){
                    return true;
                }
                return false;
            }
            return this.value.equals(input.value);
        }
        return false;
    }

    public Node getNext() {
        return this.next;
    }
}
