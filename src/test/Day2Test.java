package test;

import net.sathis.Day2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {

    @Test
    void testRecursive() {
        int[] sizes = {40, 20, 30, 10, 30};
        int[] sizes2 = {10, 20, 30, 40, 30};

        assertEquals(Day2.getCountRecursive(sizes), 26000);
        assertEquals(Day2.getCountRecursive(sizes2), 30000);
    }
}
