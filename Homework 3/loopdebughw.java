import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //P1: This one only prints 0-9, can you fix it so it prints 1-10?
        System.out.println("Problem 1");
        for (int i = 1; i <= 10; i++){
            System.out.println(i);
        }

        //P2: Ask the user for a number. Create a loop to find the factorial of it
        //(factorial = X!, X being the user input, Factorials are every digit before X multiplied together)
        System.out.println("Problem 2");
        System.out.println("Enter a number and I will tell you the fatorial: ");
        int number = scanner.nextInt();
        int factorial = 1;

        //here's a hint
        for (int i = 1; i <= number; i++){
            factorial *= i;
        }
            
            
            System.out.println("The factorial of " + number + " is " + factorial);

        

        //P3: Ask the user for a number, and then add together every OTHER digit (starting from 1)
        System.out.println("Problem 3");
        System.out.println("Enter a number and I will tell you the sum of every other number: ");
        scanner.nextLine();
        //No hint! what do you need to complete this task?
        String inputnum = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < inputnum.length(); i += 2){
            sum += Character.getNumericValue(inputnum.charAt(i));
            //indexing to add up every other number that was typed
            //.getNumericValue returns the int value of a character

        }
            System.out.println("The sum of every other digit is " + sum);


        


        //P4: Why does this loop never stop!
        //what can you do to break out of the loop after it prints once?
        //it doesnt stop because it remains true
        System.out.println("Problem 4");
        boolean run = true;
        while (run == true){
            System.out.println("I printed once!");
            run = false;
        }

        //P5: Take a string from the user and print them the reverse!
        System.out.println("Problem 5");
        System.out.print("Enter a word to be put in reverse: ");
        String userinput = scanner.nextLine();
        //hint
        String reverse = "";
            for(int i = userinput.length() - 1; i >=0; i--){
                
                reverse += userinput.charAt(i);
                //indexing again but in reverse
            }
                System.out.print(reverse);
            
            
            scanner.close();

    }
}

