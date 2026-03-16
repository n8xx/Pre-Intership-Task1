
import CustomLinkedList.CustomLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class AddTest {
    private CustomLinkedListImpl<String> list;
    private CustomLinkedListImpl<Integer> intlist;
    @BeforeEach
    void setUp() {
        list = new CustomLinkedListImpl<String>();
        intlist = new CustomLinkedListImpl<Integer>();
    }


        @Test
        @DisplayName("addFirst() should add first element in the beginning")
        void testAddFirst(){
            list.addFirst("first");
            list.addFirst("second");

            assertEquals(2,list.size());
            assertEquals("second", list.getFirst());
            assertEquals("first", list.getLast());
        }
        @Test
        @DisplayName("addFirst() should add first element in the end")
        void testAddLast(){
            list.addLast("first");
            list.addLast("second");

            assertEquals(2,list.size());
            assertEquals("first", list.getFirst());
            assertEquals("second", list.getLast());
        }

        @Test
        @DisplayName("addshould add first element in the end")
        void testAdd(){
            list.add("A");
            list.add("B");
            list.add("C");

            assertEquals(3,list.size());
            assertEquals("A", list.getFirst());
            assertEquals("C", list.getLast());
        }
        @Test
        @DisplayName("addshould add first element in the end")
        void testAddWithIndexes(){
        list.add("A");
        list.add("C");
        list.add(1,"B");

        assertEquals(3,list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        }
        @Test
        @DisplayName("add with index 0 should work like addLast")
        void testAddAtIndexZero(){
        list.add(0,"A");
        list.add(0,"B");

        assertEquals(2,list.size());
        assertEquals("B",list.getFirst());
        assertEquals("A",list.getLast());
        }
    @Test
    @DisplayName("add with index of size should work like addLast")
    void testAddWithIndexSize(){
        list.add("A");
        list.add("B");
        list.add(list.size(), "C");
        assertEquals(3,list.size());
        assertEquals("C",list.getLast());
    }
    @Test
    @DisplayName("add with invalid index should throw IndexOutOfBoundsException")
    void testWithInvalidIndex(){
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(-1,"A"));
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(1,"A"));
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(2,"B"));
    }
    }

