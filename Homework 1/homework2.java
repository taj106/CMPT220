
    //always start with importing our scanner so we can use it!
import java.util.Scanner;


/* our first practice file!
* create a 3 question quiz game (lots of if/else likely)
* requirements: keep track of the user's score, has to have at least 3 questions, use if/else
* can be any topic you pick :) feel free to pick some obscure or niche topics!
* good luck!
* */

public class homework2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
    //I am going to make the quiz based on if you are able to run for president
    //due to elections coming up I thought it would be fun
    //setting the user score equal to 0 due to it being a counter
    //first question
        System.out.println("Question 1: What is the minimum age required to be the American President? ");
        System.out.print("Please type in the minimum age: ");
         //now I will record the answer
        int answer1 = scanner.nextInt();
            if (answer1 == 35){
                System.out.println("This is correct hurrayy");
                score++;
                //adding to the user score as well
                 }else{
                    System.out.println("Incorrect womp womp, the right answer is 35");
                 }
                 scanner.nextLine();
            
                System.out.println(" Question 2: In which country must you be born to be eligible for presidency ");
                System.out.print("Please type your answer(abbreviations of shortened names of countries will not be accepted): ");
                String answer2 = scanner.nextLine();
                System.out.println(answer2);
                //I tried to use == but it would not work so I used .equals instead and it worked for the string
                if (answer2.equals("The United States of America")){
                    System.out.println("This is the correct answer good job! ");
                    score++;
                
                }else {
                    System.out.println("This is incorrect one must be born in The United States of America. ");

                }
                System.out.println("Question 3 : How many years do you have to live in America to run for president? ");
                System.out.print("Please type in the amount of years required: ");
                int answer3 = scanner.nextInt();
                if (answer3 == 14){
                    System.out.println("You are right !");
                    score++;
                
                }else{
                    System.out.println("You are wrong, the right answer is 14");
                }

                System.out.println("You have finished the quiz congrats! ");
                System.out.println("Your quiz score is " + score + " out of 3 ");


                scanner.close();
            

            }
        }








    