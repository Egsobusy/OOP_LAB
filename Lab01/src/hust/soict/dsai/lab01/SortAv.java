import java.util.Scanner;
import java.util.Arrays;;

public class SortAv {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in); 

        System.out.println("Size of array: ");
        int n = keyboard.nextInt();

        int arr[] = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++)
        {
            if(keyboard.hasNextInt())
            {
                arr[i] = keyboard.nextInt();
                sum += arr[i];
            }
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i]);
            System.out.print(" ");
        }

        float avg = sum / n;

        System.out.println();
        System.out.println("Sum is " + sum + ".");
        System.out.println("Average is " + avg + ".");
    }
}
