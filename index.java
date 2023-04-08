import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // constants
        final int monthsPerYear = 12;
        final int percentage = 100;

        int principal = 0;
        double annualInterestRate = 0;
        int period = 0;

        // this code asks the principal
        do {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal < 1000 || principal > 1_000_000)
                System.out.println("Enter a value between 1000 and 1.000.000");
        } while (principal < 1000 || principal > 1_000_000);


        // this code asks the annualInterestRate
        do {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextDouble();
            if (annualInterestRate < 0 || annualInterestRate > 30) {
                System.out.println("Enter a value greater than 0 and less/equal to 30");
            }
        } while (annualInterestRate < 0 || annualInterestRate > 30);
        double monthlyInterestRate = annualInterestRate / monthsPerYear / percentage; // -> calculating annualInterestRate


        // this code asks the period of years
        do {
            System.out.print("Period (years): ");
            period = scanner.nextInt();
            if (period < 1 || period > 30) {
                System.out.println("Enter a value between 1 to 30");
            }
        } while (period < 1 || period > 30);
        period *= monthsPerYear;

        
        // mortgage calculation
        double mortgage = principal * monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, period)) / (Math.pow(1 + monthlyInterestRate, period) - 1);
        String result = NumberFormat.getCurrencyInstance().format(mortgage); // -> getting currency format
        System.out.println("mortgage: " + result);
    }
}
