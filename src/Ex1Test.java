//package assignments.ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest()
    {
        assertEquals("02b", Ex1.int2Number(0,2)); // The num 0
        assertEquals("F4240b9" , Ex1.int2Number(1000000,10)); // A big number
        assertEquals("Ab16", Ex1.int2Number(10,16)); // Char and 16 base
        assertEquals("1b2",Ex1.int2Number(1,2));// Check number 1
    }
    @Test
    void maxIndexTest()
    {
       String[]arr1={"1b2","10bG","10bA","7b8"}; // Different values
        assertEquals(1, Ex1.maxIndex(arr1));
        String[]arr2={"1b2","zzbG","101bA","7b8"}; //Invalid number
            assertEquals(2, Ex1.maxIndex(arr2));
       String[]arr3={"1b2","1b5","1b7","1b9"} ; //Same values but not the same base
        assertEquals(0, Ex1.maxIndex(arr3));
       String[]arr4={"7bA"} ; //Only one element
       assertEquals(0,Ex1.maxIndex(arr4));
    }

    @Test
    void sameNumTest() {
        String n1="101bA"; //Same values, different bases
        String n2="65bG";
        assertFalse(Ex1.equals(n1,n2)); //True
        String n3="10bA"; //Different values, different bases
        String n4="7b8";
        assertFalse(Ex1.equals(n3,n4));//False
        String n7 ="ZZb10"; //Invalid numbers
        String n8 = "101b10";
        assertFalse(Ex1.equals(n7,n8));//False
}


}