import CustomLinkedList.CustomLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EqualsHashcodeTest {
    CustomLinkedListImpl<String> list ;
    CustomLinkedListImpl<String> listEqual ;
    CustomLinkedListImpl<String> listUnequal ;
    @BeforeEach
    void setUp() {
        list = new CustomLinkedListImpl<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        listEqual = new CustomLinkedListImpl<String>(list);
        listUnequal = new CustomLinkedListImpl<String>();
        listUnequal.add("4");
        listUnequal.add("5");
        listUnequal.add("6");

    }
    @Test
    void equals_shouldTrueWhenTheSameObject() {
        assertTrue(list.equals(list));
    }
    @Test
    void equals_shouldReturnTrueWhenObjectsAreEqual() {
        assertTrue(listEqual.equals(list));
    }
    @Test
    void equals_shouldReturnFalseWhenObjectsAreNotEqual() {
        assertFalse(listUnequal.equals(list));
    }
    @Test
    void equals_shouldReturnFalseWhenListIsNull() {
        assertFalse(list.equals(null));
    }
    @Test
    void hashCode_shouldReturnTrueWhenEquals() {
        assertEquals(list.hashCode(), listEqual.hashCode());
    }
    @Test void hashCode_shouldReturnFalseWhenNotEquals() {
        assertNotEquals(list.hashCode(), listUnequal.hashCode());
    }





}
