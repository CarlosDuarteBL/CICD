package fact.it.projectthemepark;

import fact.it.projectthemepark.model.Visitor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class VisitorTests {

    /**
     * Test of constructor en getters
     */
    @Test
    public void testConstructorEnGetters() {

        Visitor visitor = new Visitor("Donald", "Duck");
        assertEquals("Donald", visitor.getFirstName());
        assertEquals("Duck", visitor.getSurName());
        assertEquals(-1, visitor.getThemeParkCode());
        assertEquals(0, visitor.getYearOfBirth());
    }

    /**
     * Test of setFirstName method, of class Visitor.
     */
    @Test
    public void testSetFirstName() {
        Visitor visitor = new Visitor("Donald", "Duck");
        visitor.setFirstName("Mickey");
        assertEquals("Mickey", visitor.getFirstName());
    }

    /**
     * Test of setSurName method, of class Visitor.
     */
    @Test
    public void testSetSurName() {
        Visitor visitor = new Visitor("Donald", "Duck");
        visitor.setSurName("Mouse");
        assertEquals("Mouse", visitor.getSurName());
    }

    /**
     * Test of setThemeParkCodemethod, of class Visitor.
     */
    @Test
    public void testSetThemeParkCode() {
        Visitor visitor = new Visitor("Donald", "Duck");
        visitor.setThemeParkCode(11);
        assertEquals(11, visitor.getThemeParkCode());
    }

    /**
     * Test of setYearOfBirth of class Visitor.
     */
    @Test
    public void testSetYearOfBirth() {
        Visitor visitor = new Visitor("Donald", "Duck");
        visitor.setYearOfBirth(2015);
        assertEquals(2015, visitor.getYearOfBirth());
    }

    /**
     * check basic functionality of Visitor: constructor, setters/getters and
     * adding wish to wishlist
     */
    @Test
    public void testBoodschappenlijstBasics() {
        Visitor visitor = new Visitor("Donald", "Duck");
        assertEquals(0, visitor.getNumberOfWishes());
        assertTrue(visitor.addToWishList("HolaHola"));
        assertEquals(1, visitor.getNumberOfWishes());
    }

    /**
     * Visitor can add maximum 5 wishes names to wishlist
     */
    @Test
    public void testBoodschappenlijstMax5() {
        Visitor visitor = new Visitor("Donald", "Duck");
        assertEquals(0, visitor.getNumberOfWishes());
        assertTrue(visitor.addToWishList("HolaHola"));
        assertEquals(1, visitor.getNumberOfWishes());
        assertTrue(visitor.addToWishList("HelaHela"));
        assertEquals(2, visitor.getNumberOfWishes());
        assertTrue(visitor.addToWishList("Hihi"));
        assertEquals(3, visitor.getNumberOfWishes());
        assertTrue(visitor.addToWishList("Hahah"));
        assertEquals(4, visitor.getNumberOfWishes());
        assertTrue(visitor.addToWishList("Howhow"));
        assertEquals(5, visitor.getNumberOfWishes());
        assertFalse(visitor.addToWishList("Hahahah"));
        assertEquals(5, visitor.getNumberOfWishes());
    }

    /**
     * Test of toString method, of class Visitor.
     */
    @Test
    public void testToString() {
        Visitor donald = new Visitor("Donald", "Duck");
        donald.setThemeParkCode(9);
        assertEquals("Visitor DUCK Donald with theme park code 9", donald.toString());
    }

}
