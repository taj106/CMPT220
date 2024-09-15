//always start with importing our scanner so we can use it!
import java.util.Scanner;

public class Debug {
    public static void main(String[] args) {
        //I've already set up a scanner with the name 'sc' for you!
        Scanner sc = new Scanner(System.in);
        //here's a good working example for you to reference!
        //first: we ask our user for our prompt
        System.out.println("What is your name? ");
        //second: we create a string variable and store the user input back to it
        String name = sc.nextLine();
        //third: we print it back out!
        System.out.println("Hello, " + name + "! ");
        

        //finish this one for me by receiving and printing the user's age back to them
        System.out.println("How old are you? ");
        //I am going to return the age as done previously with the name using the next function
        Integer age = sc.nextInt();
        //I am going to display the users name and age in a sentence.
        System.out.println("Hello, " + name + " you are " + age + " years old!");


        //can you do some math for me? take these variable and print out the sum of them!
        int num1 = 10;
        int num2 = 37;
        //?
        // I am going to set the sum equal to num1 plus num2
        Integer sum = num1 + num2;

        System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum );


    

    }
}