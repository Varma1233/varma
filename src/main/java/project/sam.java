package project;

public class sam {

    public static int findKey(int input1, int input2, int input3) {
        // Get the digits of the numbers
        int[] digits1 = getDigits(input1);
        int[] digits2 = getDigits(input2);
        int[] digits3 = getDigits(input3);

        // Calculate the key
        int key = (max(digits1[0], digits2[0], digits3[0]) - min(digits1[0], digits2[0], digits3[0])) * 1000
                + (max(digits1[1], digits2[1], digits3[1]) - min(digits1[1], digits2[1], digits3[1])) * 100
                + (max(digits1[2], digits2[2], digits3[2]) - min(digits1[2], digits2[2], digits3[2])) * 10
                + (max(digits1[3], digits2[3], digits3[3]) - min(digits1[3], digits2[3], digits3[3]));

        return key;
    }

    // Helper method to get digits of a number
    private static int[] getDigits(int num) {
        return new int[] {
            num / 1000,        // Thousands place
            (num / 100) % 10,  // Hundreds place
            (num / 10) % 10,   // Tens place
            num % 10           // Units place
        };
    }

    // Helper methods to find max and min of three numbers
    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        // Test the function with sample inputs
        int input1 = 3521;
        int input2 = 2452;
        int input3 = 1352;

        int key = findKey(input1, input2, input3);
        System.out.println("Key: " + key);  // Output should be 2231
    }
}
