/*
challenge file!
this one isn't too tough but it does require a little bit of writing and some googling
figure out how to take a string from the user
then print back out every individual letter one letter per line
I also am requiring a small write up: explain your discovery to me.
how did you figure out how to do this? can you translate your code into simple terms? 
you need to explain why you picked your for loop conditional and what's doing the work with the string
if you're confused reach out!
 */

 import java.util.Scanner;

 public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Here I am prompting the user to type in any word of their choice so we can split it up letter by letter
        System.out.print("Please enter a word: ");
        String wordinput = scanner.nextLine();
        //saving the user input obviously

        //using a for loop we will be setting the counter which is i equal to 0 to begin  
        //the loop continues to run as long the counter is less than the length of the user input using the .length function which I looked up because I was unsure
        //after each loop the counter i gets increased by one because the word length and counter must match
        

        for (int i = 0; i < wordinput.length(); i++){
            System.out.println(wordinput.charAt(i));
            //finally when i is greater than the input length the loop stops 
            //once the loop stops I used the .charAt function which is indexing through the counter and word input
            //the .charAt was explained to me in class because I had no idea what the hell to print out once the loop finished
            //but now I know it is used for indexing which is matching the counter number with the letters of the input
            //0 being the first letter 1 being the second letter and so on...



        }



        scanner.close();
    }
}
