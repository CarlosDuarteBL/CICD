package fact.it.projectthemepark;

import fact.it.projectthemepark.model.Attraction;
import fact.it.projectthemepark.model.ThemePark;
import fact.it.projectthemepark.model.Visitor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ThemeParkTests {

    /**
     * Test of constructor en getters
     */
    @Test
    public void testConstructorEnGetters() {
        ThemePark efteling = new ThemePark("Efteling");
        assertEquals("Efteling", efteling.getName());
    }

    /**
     * Test of setName method, of class ThemePark.
     */
    @Test
    public void testSetName() {
        ThemePark efteling = new ThemePark("Efteling");
        efteling.setName("Efteling");
        assertEquals("Efteling", efteling.getName());
    }

    /**
     * check constructor of themePark + adding of attraction check if you can
     * find an attraction by name
     */
    @Test
    public void checkToevoegenAfdelingenEnOphalenAantal() {
        ThemePark park1 = new ThemePark("Bobbejaanland");
        assertEquals(0, park1.getNumberOfAttractions());
        Attraction attraction = new Attraction("ElRiio");
        park1.addAttraction(attraction);
        assertEquals(1, park1.getNumberOfAttractions());
        Attraction attraction1 = new Attraction("Fury");
        park1.addAttraction(attraction1);
        assertEquals(2, park1.getNumberOfAttractions());
        Attraction[] array = new Attraction[2];
        array[0] = attraction;
        array[1] = attraction1;
        assertArrayEquals(array, park1.getAttractions().toArray());
    }



    /**
     * Test of search by Name
     */
    @Test
    public void testSearchAttractionbyName() {
        ThemePark park2 = new ThemePark("Bobbejaanland");
        assertEquals(0, park2.getNumberOfAttractions());
        Attraction groenten = new Attraction("ElRio");
        park2.addAttraction(groenten);
        assertEquals(1, park2.getNumberOfAttractions());
        Attraction attraction = new Attraction("Fury");
        park2.addAttraction(attraction);
        assertEquals(2, park2.getNumberOfAttractions());
        assertNotNull(park2.searchAttractionByName("Fury"));
        assertEquals(attraction.getName(), park2.searchAttractionByName("Fury").getName());
        assertNull(park2.searchAttractionByName("blabla"));
    }

    /**
     * before a Visitor can make his reservations, he has to register to the
     * ThemePark as result of this registration he will receive a theme park code
     */
    @Test
    public void testRegistreerKlant() {
        Visitor k1 = new Visitor("Donald", "Duck");
        ThemePark efteling = new ThemePark("Efteling");
        efteling.registerVisitor(k1);
        assertEquals(1, k1.getThemeParkCode());
        Visitor k2 = new Visitor("Mickey", "Mouse");
        efteling.registerVisitor(k2);
        assertEquals(2, k2.getThemeParkCode());
        assertEquals(2, efteling.getNumberVisitors());
    }

}
