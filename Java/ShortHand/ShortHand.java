package ShortHand;

public class ShortHand {
    public static void main(String[] args) {

        try {
            // declare byte variable
            byte b = 8;
            // b = (byte) b * 2.5;
            // b = b * 2.5;
            b *= 2.5;
            System.out.println("\nThe Value of b is = " + b);

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Exception Raised : " + e);
        }
    }
}
