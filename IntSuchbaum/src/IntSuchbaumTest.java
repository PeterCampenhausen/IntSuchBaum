import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntSuchbaumTest {
    IntSuchbaum baum;

    @BeforeEach
    void setUp() {
        baum = new IntSuchbaum();
    }

    @AfterEach
    void tearDown() {
        baum = null;
    }

    @Test
    void isEmpty() {
        assertTrue(baum.isEmpty());
        baum.insert(3);
        assertFalse(baum.isEmpty());
    }

    @Test
    void insert() {
        baum.insert(3);
        baum.insert (2);
        baum.insert (5);
        baum.insert (4);
        baum.insert (1);
        baum.insert (7);
        baum.insert(5);
        assertEquals("(((1)2)3((4)5(7)))", baum.toString());
    }

    @Test
    void contains() {
        baum.insert(3);
        baum.insert (2);
        baum.insert (5);
        baum.insert (4);
        baum.insert (1);
        baum.insert (7);
        assertTrue(baum.contains(4));
        assertFalse(baum.contains(6));
    }

    @Test
    void hoehe() {
        baum.insert(3);
        assertEquals(1, baum.hoehe());
        baum.insert (2);
        baum.insert (5);
        baum.insert (4);
        baum.insert (1);
        baum.insert (7);
        baum.insert(8);
        assertEquals(3, baum.hoehe());
    }

    @Test
    void size() {
        baum.insert(3);
        baum.insert (2);
        baum.insert (5);
        baum.insert (4);
        baum.insert (1);
        baum.insert (7);
        baum.insert(8);
        assertEquals(7, baum.size());
    }
}