//This is assuming you have your file in the correct directory, i included a reference of where your txt file should be in the brightspace assignment
//based off what we learned in class about files, you need to determine how it's best to read the text file included in the assignment 
//after you've read and kept track of the text, then i need you to figure out:
/*
1. what names had over a 3.5 gpa (using coding, of course, not your eyes)
2. how many names are there total?
*/
//here's the imports you will need to start, and i've left some code with some blanks for you to figure out
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class filepracticehw {
    public static void main(String[] args) {
        //file path
        File inputfile = new File("practice.txt"); // Fill in the file path here

        //store names
        List<String> gpaNames = new ArrayList<>();

        //counter
        int totalNames = 0;

        try {
            Scanner input = new Scanner(inputfile);

            //line by line
            while (input.hasNext()) {
                String name = input.nextLine(); 

            
                if (input.hasNext()) {
                    String gpa = input.nextLine(); 

                    
                    if (gpa.compareTo("3.5") > 0) {
                        gpaNames.add(name);  
                    }

                    //add to counter
                    totalNames++;
                }
            }

            
            input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: The file 'practice.txt' could not be found.", e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while processing the file.", e);
        }

        //print names with gpa > 3.5
        System.out.println("Names with GPA > 3.5:");
        for (String name : gpaNames) {
            System.out.println(name);
        }

        //print total number of names
        System.out.println("Total number of names: " + totalNames);
    }
}

