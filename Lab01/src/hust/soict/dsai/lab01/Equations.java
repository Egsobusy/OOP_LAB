// 2.2.6

import java.util.Scanner;
import java.lang.Math;

public class Equations {
    public static void main(String args[]) {
        Scanner keyboard  = new Scanner(System.in);

                
        // First task: ax + b = 0
        System.out.println("The first-degree equation (linear equation) with one variable.");
        System.out.println("a? ");
        double a = keyboard.nextDouble();
        System.out.println("b? ");
        double b = keyboard.nextDouble();
        if (a == 0){
            System.out.println("No solution!");
        }
        else 
        {
            System.out.println("x = " + (-b / a));
        }
        
        

        // Second task: 𝑎11𝑥1+𝑎12𝑥2=𝑏1; 𝑎21𝑥1+𝑎22𝑥2=𝑏2
        System.out.println("The system of first-degree equations (linear system) with two variables.");
        System.out.println("a11?");
        double a11 = keyboard.nextDouble();
        System.out.println("a12?");
        double a12 = keyboard.nextDouble();
        System.out.println("b1?");
        double b1 = keyboard.nextDouble();
        System.out.println("a21?");
        double a21 = keyboard.nextDouble();
        System.out.println("a22?");
        double a22 = keyboard.nextDouble();
        System.out.println("b2?");
        double b2 = keyboard.nextDouble();

        if ((a11 == 0 && a12 == 0 && b1 != 0) || (a21 == 0 && a22 == 0 && b2 != 0))
        {
            System.out.println("No solution!");
        }
        else if(a11 == 0 && a12 == 0 && a21 == 0 && a22 == 0 && b1 == 0 && b2 == 0)
        {
            System.out.println("Infinite solution!");
        }
        else if((a11 == 0 && a12 == 0 && b1 == 0) ||(a21 == 0 && a22 == 0 && b2 == 0))
        {
            System.out.println("No solution!");
        }
        else
        {
            double x = (b1 * a22 - b2 * a12) / (a11 * a22 - a21 * a12);
            double y = (b1 - x * a11) / a12;
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }

        
        
        // Third task: ax^2 + bx + c = 0
        System.out.println("The second-degree equation with one variable.");
        System.out.println("a?");
        a = keyboard.nextDouble();
        System.out.println("b?");
        b = keyboard.nextDouble();
        System.out.println("c?");
        double c = keyboard.nextDouble();

        if(a == 0)
        {
            if(b == 0)
            {
                System.out.println("No solution!");
            }
            else 
            {
                System.out.println("x1 = x2 = " + (-c / b));
            }
        }
        else
        {
            Double delta = b * b - 4 * a * c;
            if(delta < 0)
            {
                System.out.println("No solution!");
            }
            else if (delta == 0)
            {
                System.out.println("x1 = x2 = " + (-b / (2 * a)));
            }
            else
            {
                System.out.println("x1 = " + ((-b + Math.sqrt(delta)) / (2 * a)));
                System.out.println("x2 = " + ((-b - Math.sqrt(delta)) / (2 * a)));
            }

        }

    }
}
