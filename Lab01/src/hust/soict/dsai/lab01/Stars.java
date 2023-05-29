import java.util.Scanner;

public class Stars{
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("n = ");
        int n = keyboard.nextInt();
        System.out.println();

        int space = n - 1;
        int slots = 1;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= space; j++) 
            {
                System.out.print(" ");
            }
            for (int j = 1; j <= slots; j++)
            {
                System.out.print("*");
            } 
            for (int j = 1; j <= space; j++) 
            {
                System.out.print(" ");
            }

            space -= 1;
            slots += 2;
            System.out.println();

        }

        System.exit(0);
    }
}

