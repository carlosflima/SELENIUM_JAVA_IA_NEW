package sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SanityTest {

    @Test
    public void testBasicMath() {
        assertEquals(2, 1 + 1, "Basic arithmetic should work");
    }
}
