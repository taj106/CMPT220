import java.util.Scanner;

public class DealOrNoDeal {
    public static void main(String[] args) {
        // create a scanner and take user input
        Scanner sc = new Scanner(System.in);

        //  cases and corresponding values
        int[] cases = new int[26];
        for (int i = 0; i < cases.length; i++) {
            cases[i] = i + 1; // 1 to 26
        }

        // corresponding values for the cases
        int[] values = new int[]{
            1, 2, 4939, 9882, 500, 43, 2500, 700,
            7200, 25000, 50000, 75000, 10, 250000,
            500000, 750000, 6546000, 32200000, 99500000,
            10000000, 38304, 938330, 6440,
            20000, 40000000, 5000
        };

        // first case selection
        System.out.println("Welcome to Deal or No Deal!");
        System.out.println("Choose your first case (Please type in a number 1-26):");
        int firstCaseIndex = sc.nextInt() - 1; // indexing
        cases[firstCaseIndex] = -1; // mark the case
        System.out.println("You have chosen case number " + (firstCaseIndex + 1) + ".");

        // store the value of first case
        int pickedFirstValue = values[firstCaseIndex];

        // the rounds and a loop for it
        for (int round = 1; round <= 6; round++) {
            System.out.println("\n--- Round " + round + " ---");

            // number of cases to remove in this round
            int casesToRemove = 7 - round; // first round removes 6, second removes 5 etc..

            // let the user to reveal cases in the round
            for (int i = 0; i < casesToRemove; i++) {
                // show remaining cases
                System.out.println("Pick a case to reveal (1-26):");
                System.out.print("Remaining cases: ");
                for (int j = 0; j < cases.length; j++) {
                    if (cases[j] != -1) { // show unrevealed cases
                        System.out.print(cases[j] + " ");
                    }
                }
                System.out.println(); 

                // user input for the case to reveal
                int caseToReveal = sc.nextInt() - 1; 
                if (cases[caseToReveal] != -1) { // check if case is valid
                    int revealedValue = values[caseToReveal];
                    System.out.println("Case " + (caseToReveal + 1) + " has a value of $" + revealedValue + ".");
                    cases[caseToReveal] = -1; // case revealed
                } else {
                    System.out.println("Invalid case number. Please choose a valid remaining case.");
                    i--; 
                }
            }

            // banker makes an offer based on remaining values
            int offer = calculateBankerOffer(cases, values);
            System.out.println("The banker offers you: $" + offer);
            System.out.println("Do you accept the offer? (yes/no):");
            sc.nextLine(); 
            String response = sc.nextLine();

            if (response.equalsIgnoreCase("yes")) {
                System.out.println("Congratulations! You accepted the offer of $" + offer + ".");
                return; // end the game
            } else {
                System.out.println("You have declined the offer. Let's continue!");
            }

            // check if only one case remains
            int remainingCases = 0;
            for (int j = 0; j < cases.length; j++) {
                if (cases[j] != -1) {
                    remainingCases++;
                }
            }
            if (remainingCases == 1) {
                break; // exit loop if only one case is left
            }
        }

        
        while (true) {
            System.out.println("\n--- Next Round ---");
            // show remaining cases
            System.out.print("Remaining cases: ");
            for (int j = 0; j < cases.length; j++) {
                if (cases[j] != -1) { 
                    System.out.print(cases[j] + " ");
                }
            }
            System.out.println(); // Move to the next line

            // take user input for the case to reveal
            System.out.println("Pick a case to reveal (1-26):");
            int caseToReveal = sc.nextInt() - 1; // idex
            if (cases[caseToReveal] != -1) { // check if case is valid
                int revealedValue = values[caseToReveal];
                System.out.println("Case " + (caseToReveal + 1) + " has a value of $" + revealedValue + ".");
                cases[caseToReveal] = -1; // case revealed
            } else {
                System.out.println("Invalid case number. Please choose a valid remaining case.");
                continue; // valid input
            }

            // banker makes an offer
            int offer = calculateBankerOffer(cases, values);
            System.out.println("The banker offers you: $" + offer);
            System.out.println("Do you accept the offer? (yes/no):");
            sc.nextLine(); 
            String response = sc.nextLine();

            if (response.equalsIgnoreCase("yes")) {
                System.out.println("Congratulations! You accepted the offer of $" + offer + ".");
                return; // end the game
            } else {
                System.out.println("You have declined the offer. Let's continue!");
            }

            // check if only one case remains
            int remainingCases = 0;
            for (int j = 0; j < cases.length; j++) {
                if (cases[j] != -1) {
                    remainingCases++;
                }
            }
            if (remainingCases == 1) {
                break; // exit loop
            }
        }

        // last case scenario
        System.out.println("All remaining cases have been revealed.");
        
        // determine value of the last case
        int lastCaseValue = 0;
        for (int j = 0; j < cases.length; j++) {
            if (cases[j] != -1) {
                lastCaseValue = values[j]; // get value of the last case
                break; // exit loop
            }
        }

        // offer user a choice between first case and last case
        System.out.println("You have one last decision to make!");
        System.out.println("Do you want to keep the value of your first case or take the value of the last remaining case?");
        System.out.println("Type 'first' to keep your first case or 'last' to take the last case:");

        // store the user choice
        String finalChoice = sc.nextLine();
        
        // reveal the values after
        if (finalChoice.equalsIgnoreCase("first")) {
            System.out.println("You chose to keep your first case with a value of: $" + pickedFirstValue);
        } else if (finalChoice.equalsIgnoreCase("last")) {
            System.out.println("You chose to take the last case with a value of: $" + lastCaseValue);
        } else {
            System.out.println("Invalid choice. You will keep your first case with a value of: $" + pickedFirstValue);
        }

      
        System.out.println("Thank you for playing Deal or No Deal!");
        System.out.println("We hope you enjoyed the game! Please come back and play again!");
    }

    // calculate the banker's offer 
    // I was a bit stuck on this part, and how to get the average so I figured I needed a sum of all the unrevealed values
    // and make an average through dividing the number of cases. I also used private static because I wanted to nest this logic.
    private static int calculateBankerOffer(int[] cases, int[] values) {
        int total = 0;
        int count = 0;

        for (int j = 0; j < cases.length; j++) {
            if (cases[j] != -1) { // only include unrevealed cases
                total += values[j]; // sum of remaining values
                count++; // count remaining cases
            }
        }

        return count > 0 ? total / count : 0; // Return average if any cases left
    }
}
