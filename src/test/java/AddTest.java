
import CustomLinkedList.CustomLinkedList;
import CustomLinkedList.CustomLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class AddTest {
    CustomLinkedListImpl<String> list ;
    CustomLinkedListImpl<Integer> intlist ;
    @BeforeEach
    void setUp() {
        list = new CustomLinkedListImpl<String>();
        intlist = new CustomLinkedListImpl<Integer>();
    }


        @Test
        void shouldAddFirstElementInBeginningAndUpdateSize(){
            assertEquals(0,list.size());
            list.addFirst("first");
            list.addFirst("second");

            assertEquals(2,list.size());
            assertEquals("second", list.getFirst());
            assertEquals("first", list.getLast());
        }
        @Test
        void shouldAddElementToTheEndAndUpdateSize(){
            assertEquals(0,list.size());
            list.addLast("first");
            list.addLast("second");

            assertEquals(2,list.size());
            assertEquals("first", list.getFirst());
            assertEquals("second", list.getLast());
        }

        @Test
        void shouldAddElementInEnd(){
            list.add("A");
            list.add("B");
            list.add("C");

            assertEquals(3,list.size());
            assertEquals("A", list.getFirst());
            assertEquals("C", list.getLast());
        }
        @Test
        void shouldAddElementAtIndex(){
        list.add("A");
        list.add("C");
        list.add(1,"B");

        assertEquals(3,list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        }
        @Test
        void shouldAddAtIndexZero(){
        list.add(0,"A");
        list.add(0,"B");

        assertEquals(2,list.size());
        assertEquals("B",list.getFirst());
        assertEquals("A",list.getLast());
        }
    @Test
    void shouldAddFirstElementIfListIsEmpty() {
        assertEquals(0,list.size());
        list.add("first");
        assertEquals(1,list.size());
    }
    @Test
    void shouldAddEWithIndexOfSizeInTheEnd(){
        list.add("A");
        list.add("B");
        list.add(list.size(), "C");
        assertEquals(3,list.size());
        assertEquals("C",list.getLast());
    }
    @Test
    void shouldThrowIndexOutOfBoundsExeptionIfInvalidIndex(){
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(-1,"A"));
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(1,"A"));
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(2,"B"));
    }
    @Test
    void shouldReturnZeroWhenListIsEmpty(){
        assertEquals(0,list.size());
    }
    }

