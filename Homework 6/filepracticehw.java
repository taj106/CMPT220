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

