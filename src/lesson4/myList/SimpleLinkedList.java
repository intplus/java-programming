package lesson4.myList;

import java.util.Iterator;

public class SimpleLinkedList implements Iterable<Object>{
    private Node root;
    private int size;

    public SimpleLinkedList() {
        size = 0;

    }
    public void addFirst(Object obj) {
        Node n = new Node();
        n.o = obj;
        if (root != null) {
            n.node = root;
        }
        root = n;
        size++;

    }
    public void addLast(Object obj) {
        Node n = new Node();
        n.o = obj;
        if (root != null) {
            Node cp = root;
            while (cp.node != null) {
                cp = cp.node;
            }
            cp.node = n;
        } else {
            root = n;
        }
        size++;
    }
    public void addAfter(Object obj, Object prev) {
        Node prevPointer = null;
        Node cp = root;

        do {
            if (cp.o == prev) {
                prevPointer = cp;
                break;
            }
            cp = cp.node;
        } while (cp != null && cp.node != null);

        if (prevPointer == null) {
            throw new IllegalStateException("List does not contain prev object");
        }
        Node n = new Node();
        n.o = obj;

        if (prevPointer.node != null) {
            n.node = prevPointer.node;
        }
        prevPointer.node = n;
        size++;

    }
    public void printList() {
        if (size == 0) {
            System.out.println("list is empty");
        }

        System.out.print("{ ");
        Node cp = root;
        while (cp.node != null) {
            System.out.print(cp.o + ", ");
            cp = cp.node;
        }
        System.out.print(cp.o);
        System.out.println(" }");

    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Iterator <Object> iterator() {
        return new SLLIterator();
    }

    private class Node {
        private Object o;
        private Node node;

    }
    private class SLLIterator implements Iterator <Object>{
        private Node cp;
        private Node prev;
        @Override
        public Object next() {
            if (cp == null && root != null) {
                cp = root;
                return cp.o;
            }
            if (hasNext()) {
                prev = cp;
                cp = cp.node;
                return cp.o;
            }
            throw new IllegalStateException("List has not elements");
        }
        @Override
        public boolean hasNext() {
            return (cp == null && root != null) || (cp != null && cp.node != null);
        }
        @Override
        public void remove() {
            if (!hasNext() && prev == null) {
                cp = null;
                root = null;
            } else if(!hasNext() && prev != null) {
                prev.node = null;
                cp = null;
            } else  if(hasNext() && prev == null) {
                root = cp.node;
                cp = root;
            } else {
                prev.node = cp.node;
                cp = cp.node;
            }
            size--;
        }
    }
}
