package net.sathis;

import org.junit.jupiter.api.Test;

public class Day1 {

    private static void hanoi(int i, String left, String right, String aux) {
        if (i > 0) {
            hanoi(i - 1, left, aux, right);
            System.out.println("Moving from " + left + " to " + right);
            hanoi(i - 1, aux, right, left);
        }
    }

    private static void hanoi(int i) {
        hanoi(i, "LEFT", "RIGHT", "MIDDLE");
    }

    public static void main(String[] args) {
        hanoi(3);
    }

    @Test
    public static void test() {
        hanoi(3);
    }
}
