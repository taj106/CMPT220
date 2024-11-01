import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // P2:
        System.out.println("Problem 2");
        System.out.print("Enter a number and I will tell you the factorial: ");
        int number = scanner.nextInt();
        int factorial = calculateFactorial(number);
        System.out.println("The factorial of " + number + " is " + factorial);

        // P3:
        System.out.println("Problem 3");
        System.out.print("Enter a number and I will tell you the sum of every other digit: ");
        scanner.nextLine(); 
        String inputnum = scanner.nextLine();
        int sum = sumEveryOtherDigit(inputnum);
        System.out.println("The sum of every other digit is " + sum);

        // P5:
        System.out.println("Problem 5");
        System.out.print("Enter a word to be put in reverse: ");
        String userinput = scanner.nextLine();
        String reverse = reverseString(userinput);
        System.out.println(reverse);

        scanner.close();
    }

    
    public static int calculateFactorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    
    public static int sumEveryOtherDigit(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i += 2) {
            sum += Character.getNumericValue(input.charAt(i));
        }
        return sum;
    }

    
    public static String reverseString(String input) {
        String reverse = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reverse += input.charAt(i);
        }
        return reverse;
    }
}
