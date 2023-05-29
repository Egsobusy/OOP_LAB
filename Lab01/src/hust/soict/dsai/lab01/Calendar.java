import java.util.Scanner;
public class Calendar {
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Month?");
        String month = keyboard.nextLine();

        System.out.println("Year?");
        int year = keyboard.nextInt();

        String [][] check_month = {{}, {"January", "Jan.", "Jan", "1"},      
        {"February", "Feb.", "Feb", "2"},
        {"March", "Mar.", "Mar", "3"},
        {"April", "Apr.", "Apr", "4"},
        {"May", "May", "May", "5"},
        {"June", "June", "Jun", "6"},
        {"July", "July", "Jul", "7"},
        {"August", "Aug.", "Aug", "8"},
        {"September", "Sept.", "Sep", "9"},
        {"October", "Oct.", "Oct", "10"},
        {"November", "Nov.", "Nov", "11"},
        {"December", "Dec.", "Dec", "12"}};

        for (int i = 1; i <= 12; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (month.equals(check_month[i][j]))
                {
                    if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
                    {
                        System.out.print("31 days.");
                    }
                    else if (i == 4 || i == 6 || i == 9 || i == 11)
                    {
                        System.out.print("30 days.");
                    }
                    else 
                    {
                        if (year % 100 == 0)
                        {
                            if(year % 400 == 0)
                            {
                                System.out.print("29 days.");
                            }
                            else
                            {
                                System.out.print("28 days.");
                            }
                        }
                        else if (year % 4 == 0)
                        {
                            System.out.print("29 days.");
                        }
                        else
                        {
                            System.out.print("28 days.");
                        }
                    }
                }
            }
        }
        System.exit(0);
    }
        
}
