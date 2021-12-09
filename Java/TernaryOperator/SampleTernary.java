package TernaryOperator;

public class SampleTernary {
    public static void main(String[] args) {
        
        // obj1 and obj2 are two objects of java.lang.Object class
        Object obj1;
        Object obj2;
        
        // Normal if-else statement
        if (true) {
           obj1 = new Integer(10);
        } else {
            obj1 = new Double(19.0);
        }
        System.out.println("\nValue of obj1 is = " + obj1);

        
        // Ternary Statement
        obj2 = true ? new Integer(10) : new Double(19.0);
        System.out.println("Value of obj2 is = " + obj2 + "\n");

    }
}
