import CustomLinkedList.CustomLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveTest {
    private CustomLinkedListImpl<String> list;
    private CustomLinkedListImpl<Integer> intlist;
    @BeforeEach
    void setUp() {
        list = new CustomLinkedListImpl<String>();
        intlist = new CustomLinkedListImpl<Integer>();
        list.addFirst("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        intlist.add(1);
        intlist.add(2);
        intlist.add(3);
        intlist.add(4);
    }
    @Test
    void shouldRemoveFirstElementAndUpdateSize() {
        assertEquals(4,list.size());
        list.removeFirst();
        assertEquals(3,list.size());
        assertEquals("second",list.getFirst());
    }
    @Test
    void shouldRemoveLastElementAndUpdateSize() {
        assertEquals(4,list.size());
        list.removeLast();
        assertEquals(3,list.size());
        assertEquals("third",list.getLast());
    }
    @Test
    void shouldRemoveElementByIndexAndUpdateSize(){
        assertEquals(4,list.size());
        list.remove(2);
        assertEquals(3,list.size());
        assertEquals("fourth",list.get(2));

    }
    @Test
    void shouldThrowsOutOfBoundsExceptionIfRemovingInvalidIndex(){
        assertThrows(IndexOutOfBoundsException.class, () -> {list.remove(-1);});
        assertThrows(IndexOutOfBoundsException.class, () -> {list.remove(6);});
    }
    @Test
    void shouldThrowsNullPointerExceptionIfRemovingFromEmptyList(){
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        assertThrows(NullPointerException.class, () -> {list.remove(0);});
    }
}
