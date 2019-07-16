package net.sathis;

public class Day1 {

    private static void hanoi(int i, String left, String right, String aux) {
        if (i > 0) {
            hanoi(i - 1, left, aux, right);
            System.out.println("Moving from " + left + " to " + right);
            hanoi(i - 1, aux, right, left);
        }
    }

    public static void hanoi(int i) {
        hanoi(i, "LEFT", "RIGHT", "MIDDLE");
    }

    public static void main(String[] args) {
        hanoi(3);
    }
}
