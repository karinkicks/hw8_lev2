package list.impl;

import list.GBIterable;
import list.GBIterator;
import list.GBList;

public class DoublyLinkedList implements GBList, GBIterable {
    private Node first;
    private int size = 0;

    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val);
            System.out.println(first);
        } else {
            add(first, val);

        }
        size++;
    }
    private void add(Node current, String val) {
        if (current.next == null) {
            current.next = new Node(val, new Node(current));
            return;
        }
        add(current.next, val);
    }

    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)) {
            first = new Node(first.next.val, null, first.next.next);
            size--;
            return true;
        }

        Node prev = first;
        Node current = first.next;
        while(current != null) {
            if (current.val.equals(val)) {
                prev.setNext(current.next);
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {
        int i=0;
        String value=null;
        if (index>size-1 || index<0){
            value="такого элемента нет";
        }
        GBIterator it = iterator();
        while (it.hasNext()) {
            if (i==index){
                value = it.next();
                break;
            }
            it.next();
            i++;
        }
        return value;
    }

    @Override
    public GBIterator iterator() {
        return new StraightForwardIterator(first);
    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "first=" + first +
                '}';
    }

    private static class Node {
        private String val;
        private Node prev;
        private Node next;

        public Node(String val) {
            this(val, null, null);
        }
        public Node(Node n) {
            this(n.val, n.prev, n.next);
        }


        public Node(String val, Node prev) {
            this(val, prev, null);
        }

        public Node(String val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "val='" + val + '\'' +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }

    public static class StraightForwardIterator implements GBIterator {
        private Node current;

        public StraightForwardIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }
    }
}
