// package AsciiDemo;

/**
 * Prnting ASCII values
 * @author Atanu Ghosh
 * 
 */

public class AsciiDemo {
    public static void main(String[] args) {
        
        // 7 bits
        // 2 ^ 7 = 128 
        // 0 - 127
        for (int i = 0; i <= 127; ++i) {
            
            System.out.printf("%d : %c\n", i, i);
        }

    }
}
