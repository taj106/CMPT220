//
/*
Take the given array and keep track of:
1. Any duplicate numbers
2. How many times the duplicate numbers appear
3. Print out those duplicate numbers with how many times they appear

 */
public class Main {
    public static void main(String[] args) {
        int[] myArray = {10, 3, 295, 38, 20, 3, 4, 267, 2445, 10, 5566, 87, 93, 17, 10, 2, 87, 267, 3176, 3, 82};

        //keeping the duplicates and the counts
        int[] duplicates = new int[myArray.length];
        int[] counts = new int[myArray.length];
        int duplicatecount = 0;
        //looping through everything
        for (int i = 0; i < myArray.length; i++) {
            int count = 1;

            // here I am checking for duplicates
            for (int j = i + 1; j < myArray.length; j++) {
                if (myArray[i] == myArray[j]) {
                    count++;
                    //adding to the count if there is a duplicate
                }
            }

            
            if (count > 1) {
                
                boolean alreadycounted = false;
                for (int k = 0; k < duplicatecount; k++) {
                    if (duplicates[k] == myArray[i]) {
                        alreadycounted = true;
                    }
                }

                
                if (alreadycounted == false) {
                    duplicates[duplicatecount] = myArray[i];
                    counts[duplicatecount] = count; //storing counts
                    duplicatecount++; 
                    //increasing the duplicate count
                }
            }
        }

        
        System.out.println("These are duplicate numbers and their counts:");
        for (int i = 0; i < duplicatecount; i++) {
            System.out.println(duplicates[i] + " appears " + counts[i] + " times");
        }
    }
}
//code was having difficulty running in vscode so I used an online compiler
