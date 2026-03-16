package CustomLinkedList;

public interface CustomLinkedList <E> {
    int size();
    boolean isEmpty();
    void addFirst(E el);
    void addLast(E el);
    boolean add(int index, E el);
    boolean add(E el);
    E getFirst();
    E getLast();
    E get(int index);
    E removeFirst();
    E removeLast();
    E remove(int index);

}