package CustomLinkedList;

import java.util.LinkedList;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CustomLinkedListImpl<E> implements CustomLinkedList<E> {
    private static final Logger logger = LogManager.getLogger();
    private Node<E> head;
    private Node<E> tail;
    private int  size;
    private int modCount = 0;

    private static class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> prev;

        Node(Node<E> prev,E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
        /*Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }*/
    }

    public CustomLinkedListImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public int size (){return this.size;}
    public boolean isEmpty(){return this.size == 0;}
    public void addFirst(E el){linkFirst(el);}

    @Override
    public void addLast(E el) {linkLast(el);}

    @Override
    public boolean add(int index, E el) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == size) {
            linkLast(el);
        } else {
            linkBefore(el, getNode(index));
        }

        return true;
    }
    @Override
    public boolean add(E el){
        linkLast(el);
        return true;
    }

    @Override
    public E getFirst() {
        if(head == null){
            logger.info("Head is null", new IndexOutOfBoundsException());
            throw new IndexOutOfBoundsException("Head is null");
        }
        return head.data;
    }

    @Override
    public E getLast() {
        if(tail == null){
            logger.info("Tail is null", new IndexOutOfBoundsException());
            throw new IndexOutOfBoundsException("Tail is null");
        }
        return tail.data;
    }

    @Override
    public E get(int index){
        if(index < 0 || index >= size){
            logger.info("Index: "+index+" Size: "+size, new IndexOutOfBoundsException());
            throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
        }
        return getNode(index).data;
    }
    private Node<E> getNode(int index) {
        Node<E> current;
        if(index < size /2){
            current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
        }else{
            current = tail;
            for(int i = size-1; i > index; i--){
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public E removeFirst() {
        Node<E> current = head;
        if(current == null){
            logger.info("Head is null", new IndexOutOfBoundsException());
            throw new IndexOutOfBoundsException("Head is null");
        }
        return unlinkFirst(head);
    }

    @Override
    public E removeLast() {
        Node<E> current = tail;
        if(current == null){
            logger.info("Tail is null", new IndexOutOfBoundsException());
            throw new IndexOutOfBoundsException("Tail is null");
        }
        return unlinkLast(tail);
    }

    @Override
    public E remove(int index) {
        if(getNode(index) == null){
            logger.info("List is empty", new NullPointerException());
            throw new NullPointerException("List is empty");
        }
        if(index < 0 || index > size){
            logger.info("Index: "+index+" Size: "+size, new IndexOutOfBoundsException());
            throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
        }
        return unlink(getNode(index));
    }

    private void linkFirst(E el){
        Node<E> first = head;
        final Node<E> newNode = new Node<>(null ,el, first);
        head = newNode;
        if (first == null)
            tail = newNode;
        else
            first.prev = newNode;
        size++;
        modCount++;
    }
    private void linkLast(E el){
        Node<E> last = tail;
        final Node<E> newNode = new Node<>(last, el,  null);
        tail = newNode;
        if(last == null){
            head = newNode;
        }
        else{
            last.next = newNode;
        }
        size++;
        modCount++;
    }
    private void linkBefore(E el, Node<E> nodeAtIndex){
        Node<E> prevNode = nodeAtIndex.prev;
        Node<E> newNode = new Node<>(prevNode,el,nodeAtIndex);
        nodeAtIndex.prev = newNode;
        if (prevNode == null) {
            head = newNode;
        } else {
            prevNode.next = newNode;
        }
        size++;
        modCount++;
    }


    private E unlinkFirst(Node<E> first) {
        final E element = first.data;
        final Node<E> next = first.next;
        first.data = null;
        first.next = null;
        head = next;
        if (next == null)
            tail = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }
    private E unlinkLast(Node<E> last) {
        final E element = last.data;
        final Node<E> prev = last.prev;
        last.data = null;
        last.prev = null; // help GC
        tail = prev;
        if (prev == null)
            head = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }
    E unlink(Node<E> x) {
        final E element = x.data;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.data = null;
        size--;
        modCount++;
        return element;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);//TODO
    }

    @Override
    public int hashCode() {
        return super.hashCode();//TODO
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while(current !=null){
            sb.append(current.data);
            sb.append(", ");

            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

