package fact.it.projectthemepark;

import fact.it.projectthemepark.model.Attraction;
import fact.it.projectthemepark.model.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AttractionTests {

    /**
     * Test of constructor en getters
     */
    @Test
    public void testConstructorEnGetters() {
        Attraction attraction = new Attraction("Tower");
        assertEquals("Tower", attraction.getName());
        Attraction attraction1 = new Attraction();
        assertEquals(null,attraction1.getName());
        Attraction attraction2 = new Attraction("Jump", 540);
        assertEquals("Jump", attraction2.getName());
        assertEquals(540, attraction2.getDuration());
    }

    /**
     * Test of setName method, of class Attraction.
     */
    @Test
    public void testSetNaam() {
        Attraction attraction = new Attraction();
        attraction.setName("Tower");
        assertEquals("Tower", attraction.getName());
    }

    /**
     * Test of setDuration, of class Attraction.
     */
    @Test
    public void testSetDuration() {
        Attraction attraction = new Attraction("Tower");
        attraction.setDuration(180);
        assertEquals(180, attraction.getDuration());
    }


    /**
     * Test of setPhoto method, of class Attraction.
     */
    @Test
    public void testSetPhoto() {
        Attraction attraction = new Attraction("Tower");
        attraction.setPhoto("testphoto.jpg");
        assertEquals("testphoto.jpg", attraction.getPhoto());
    }

    /**
     * Test of setResponsible method, of class Attraction.
     */
    @Test
    public void testResponsible() {
        Attraction attraction = new Attraction("Tower");
        Staff Mickey = new Staff("Mickey", "Mouse");
        attraction.setResponsible(Mickey);
        assertEquals(Mickey, attraction.getResponsible());
    }
}
