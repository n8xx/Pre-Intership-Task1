import CustomLinkedList.CustomLinkedListImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GetTest {
    static CustomLinkedListImpl<String> list = new CustomLinkedListImpl<String>();
    static CustomLinkedListImpl<Integer> intlist = new CustomLinkedListImpl<Integer>();
    @BeforeAll
    static void setUp() {
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        intlist.add(1);
        intlist.add(2);
        intlist.add(3);
        intlist.add(4);

    }
    @Test
    void shouldGetFirstElement() {
        assertEquals("first",list.getFirst());
        assertEquals(1,intlist.getFirst());
    }
    @Test
    void shouldGetLastElement() {
        assertEquals("fourth",list.getLast());
        assertEquals(4,intlist.getLast());
    }
    @Test
    void shouldGetElementByIndex(){
        assertEquals("second",list.get(1));
        assertEquals(3,intlist.get(2));
    }
    @Test
    void shouldGetLastElementByIndexOfSize(){
        assertThrows(IndexOutOfBoundsException.class, ()->{list.get(list.size());});
        assertThrows(IndexOutOfBoundsException.class, ()->{intlist.get(intlist.size());});

    }

}
