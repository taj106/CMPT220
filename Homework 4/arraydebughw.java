import java.util.Arrays;
//Our cheaty array helper file <3
public class Main {
    public static void main(String[] args) {

        //Create me an array named "nameArray" that is a string and has 4 values in it, give me 4 names of people or animals you care about
        String[] nameArray = {"Jay", "Brian", "Ariana", "Sara"};

        //Create me an array without any values, but it's an integer array named "numArray"
        int[] numArray = new int[0];

        //Create me an int array named "newArray" and set it to have 20 null spaces
        int[] newArray = new int[20];




        
        //Here's our first practice array!
        String[] sortMe = {"Apple","Kiwi","Orange","Banana","Watermelon","Strawberry"};
       //What method is missing here to actually sort our array?
        Arrays.sort(sortMe); // we were missing sort
        //And what method is missing here to print out that array?
        System.out.println(Arrays.toString(sortMe));
        //After this, you cannot use the array helper file, gotta go back to the old ways!!

        //another one!
        int addMe[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //How would we add every index together and print out the sum??
        //A small hint:
        int sum = 0;
        for(int i = 0; i < addMe.length; i ++){
            sum += addMe[i];
            System.out.println(sum);

        }
        
        //thinking one! here's an array
        int maxMe[] = {280, 4892, 134, 23, 1937, 5329, 932, 89};
        //What would you have to do to find the largest number and then print that value?
        int max = maxMe[0];
        for (int i = 1; i < maxMe.length; i ++) {
            if (maxMe[i] > max) {
                max = maxMe[i];


            }
        }
        System.out.println("The largest number here is:" + max);

    }
}
