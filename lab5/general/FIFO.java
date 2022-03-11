package lab5.general;

import java.util.NoSuchElementException;

public class FIFO {

    private Node first;
    private Node last;
    private Node node;
    private int size = 0;
    private int maxSize = 0;

    public void add(Object item) {
        node = new Node(item);
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

    public Node getFirst(){
        return first;
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
            queue = queue + "(" + node.getValue() + ") ";
            node = node.getNext();
        }
        return queue;
    }

    public Node getIndex(int index){
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }else {
            Node iterator = node.getNext();
            for(int i = 0; i < index; i++){
                iterator = iterator.getNext();
            }
            return iterator;
        }
    }
    public Object getIndexValue(int index){
        return getIndex(index).getValue();
    }


    public class Node {

        Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void setNext(Node node) {
            next = node;
        }

        public Node getNext() {
            return this.next;
        }
    }
}
