import java.io.IOException;
import java.util.Scanner;

public class SimpleCalculator  {
    public static void main(String[] args) throws IOException, InterruptedException {
        double n1, n2;
        String operation;

        Scanner scannerObject = new Scanner(System.in);

        System.out.print("Enter first number ");
        n1 = scannerObject. nextDouble();

        System.out.print("Enter second number ");
        n2 = scannerObject. nextDouble();

        Scanner op = new Scanner(System.in);
        System.out.print("Enter your operation: (+,-,/,*,%) ");
        operation = op.next();

        switch (operation)  {
            case "+":
                System.out.println("Addition result: " + (n1 + n2));
                break;

            case "-":
                System.out.println("Subtraction result: " + (n1 - n2));
                break;

            case "/":
                System.out.println("Division result " + (n1 / n2));
                break;

            case "*":
                System.out.println("Multiplying result: " + (n1 * n2));
                break;

            case "%":
                System.out.println("Remainder result " + (n1 % n2));
                break;

            default:
                System.out.println("Opps, Something went wrong");

        }

    }
}