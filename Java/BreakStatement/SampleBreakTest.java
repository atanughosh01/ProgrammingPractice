// package BreakStatement;

import java.util.*;

public class SampleBreakTest {
    public static void main(String[] args) {
        
        System.out.print("\nEnter an Integer Number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // break switch loops

        System.out.println("\n=================== Pattern - 1 ===================");

        // Pattern - 1
        for (int i = 1; i <= n; ++i) {

            for (int j = 1; j <= n; ++j) {

                System.out.print("* ");
            }

            System.out.println(" ");
        }

        System.out.println("\n=================== Pattern - 2 ===================");

        // Pattern - 2
        for (int i = 1; i <= n; ++i) {

            for (int j = 1; j <= n; ++j) {

                if (i == n-2)
                    break;                  // Unlabelled break statement
                
                System.out.print("* ");
            }

            System.out.println(" ");
        }

        System.out.println("\n=================== Pattern - 3 ===================");

        // Pattern - 3
        flag:
        for (int i = 1; i <= n; ++i) {

            for (int j = 1; j <= n; ++j) {

                if (i == n-2)
                    break flag;                 // Labelled break statement

                System.out.print("* ");
            }

            System.out.println(" ");
        }

        System.out.println("\n================= Patterns Printed =================\n");

        sc.close();

    }
}
