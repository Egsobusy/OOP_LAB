// 2.2.5

import java.util.Scanner;

public class Calculate {
    public static void main(String args[]) {
        Scanner keyboard  = new Scanner(System.in);

        System.out.println("First num? ");
        double x = keyboard.nextDouble();
        System.out.println("Second num? ");
        double y = keyboard.nextDouble();
        
        System.out.println("Sum = " + (x + y));
        System.out.println("Difference = " + (x - y));
        System.out.println("Product = " + (x * y));
        System.out.print("Quotient = ");
        if (y == 0){
            System.out.print("NULL");
        }
        else 
        {
            System.out.print(x / y);
        }

        System.exit(0);
    }
}
