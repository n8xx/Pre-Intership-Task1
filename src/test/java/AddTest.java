import CustomLinkedList.CustomLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class AddTest {
    CustomLinkedListImpl<String> list ;
    @BeforeEach
    void setUp() {
        list = new CustomLinkedListImpl<String>();

    }
        // Test for size()
        @Test
        void size_shouldReturnSize(){
            list.add("A");
            list.add("B");
            assertEquals(2,list.size());
        }
        @Test
        void size_shouldReturnZeroWhenListIsEmpty(){
            assertEquals(0,list.size());
        }
        // Test for addFirst()
        @Test
        void addFirst_shouldAddFirstElementInBeginningAndUpdateSize(){
            assertEquals(0,list.size());
            list.addFirst("first");
            list.addFirst("second");

            assertEquals(2,list.size());
            assertEquals("second", list.getFirst());
            assertEquals("first", list.getLast());
        }
        // Test for addLast()
        @Test
        void addLast_shouldAddElementToTheEndAndUpdateSize(){
            assertEquals(0,list.size());
            list.addLast("first");
            list.addLast("second");

            assertEquals(2,list.size());
            assertEquals("first", list.getFirst());
            assertEquals("second", list.getLast());
        }
        // Test for add()
        @Test
        void add_shouldAddElementInEndAndUpdateSize(){
            list.add("A");
            list.add("B");
            list.add("C");

            assertEquals(3,list.size());
            assertEquals("A", list.getFirst());
            assertEquals("C", list.getLast());
        }
        @Test
        void add_shouldAddElementAtIndexAndUpdateSize(){
        assertEquals(0,list.size());
        list.add("A");
        list.add("C");
        assertEquals(2,list.size());
        list.add(1,"B");

        assertEquals(3,list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        }
        @Test
        void add_shouldAddAtIndexZeroAndUpdateSize(){
        assertEquals(0,list.size());
        list.add(0,"A");
        list.add(0,"B");


        assertEquals(2,list.size());
        assertEquals("B",list.getFirst());
        assertEquals("A",list.getLast());
        }
    @Test
    void add_shouldAddFirstElementIfListIsEmpty() {
        assertEquals(0,list.size());
        list.add("first");
        assertEquals(1,list.size());
    }
    @Test
    void add_shouldAddInTheEndIfIndexOfSize(){
        list.add("A");
        list.add("B");
        list.add(list.size(), "C");
        assertEquals(3,list.size());
        assertEquals("C",list.getLast());
    }
    // Test for invalid index exception
    @Test
    void add_shouldThrowIndexOutOfBoundsExсeptionIfInvalidIndex(){
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(-1,"A"));
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(1,"A"));
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(2,"B"));
    }
    }

