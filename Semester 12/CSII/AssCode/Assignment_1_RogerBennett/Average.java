import java.util.Scanner;

public class Average {
    static Scanner userIn = new Scanner(System.in);
    public static void main (String[] args) {
        

        double Total = 0;
        double Count = 0;
        double Avg;

        System.out.println("Enter a series of numbers. Enter a negative number to quit.");

        double Num = userIn.nextDouble();
        while (Num >= 0){
            Total += Num;
            Count += 1;

            Num = userIn.nextDouble();
        }

        Avg = Total / Count;

        System.out.print("You entered " + Count + " numbers. The average is " + Avg + ".");
    }
}
