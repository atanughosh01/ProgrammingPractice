package OddEven;

import java.util.*;

public class OddEven {
    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // System.out.print("\nEnter Integer Number to Check Odd/Even : ");
        // int num = sc.nextInt();

        Scanner sc = new Scanner(System.in);
        int num = 0;

        try {

            System.out.print("\nEnter Integer Number to Check Odd/Even : ");
            num = sc.nextInt();

        } catch (Exception e) {

            // e.printStackTrace();
            System.out.println("\nException Raised : " + e);
            System.exit(0);

        } finally {

            System.out.println("\nExecution Stopped!");
        }


        if (num % 2 == 0) {
            System.out.println("\nThe Number " + num + " is EVEN");
        } else {
            System.out.println("\nThe Number " + num + " is ODD");
        }

        sc.close();
    }
}
