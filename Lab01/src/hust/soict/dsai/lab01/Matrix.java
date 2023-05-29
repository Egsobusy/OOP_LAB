import java.util.Scanner;

import javafx.print.PrintColor;

public class Matrix {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in); 

        System.out.println("Size of row: ");
        int r = keyboard.nextInt();
        System.out.println("Size of column: ");
        int c = keyboard.nextInt();

        int arr1[][] = new int[r][c];
        int arr2[][] = new int[r][c];
        
        for (int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(keyboard.hasNextInt())
                {
                    arr1[i][j] = keyboard.nextInt();
                }
            }
        }

        for (int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(keyboard.hasNextInt())
                {
                    arr2[i][j] = keyboard.nextInt();
                }
            }
        }

        for (int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                System.out.print(arr1[i][j] + arr2[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
