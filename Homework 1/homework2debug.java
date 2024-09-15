
    
public class homework2debug {
    public static void main(String[] args) {

        //for this section: are these all printing the best option? If they aren't, fix it!
        //(However you interpret 'fix' is fine i promise, any way you fix it shows you get the concept to me)
        int var1 = 4;
        if (var1 > 4){
            System.out.println("Var1 is greater than 4");
            // I changed the else statement into an else if because it was incorrect and made the else statement be var1 equal to 4
        }else if (var1 < 4)
            System.out.println("Var1 is less than 4");
            // if it is not greater or less then it must be equal
        else {
            System.out.println("var1 is equal to 4");
        }



        int var2 = 6;
        if (var2 == 5){
            System.out.println("Var2 is 5");
        } else if (var2 > 5){
            System.out.println("Var2 is greater than 5");
        } else {
            System.out.println("Var2 is less than 5");
        
        //this else statement is not needed as the greater and less than is covered} else{
            //System.out.println("Var2 is 6");
        }
        //no fix needed here everything is good
        int var3 = 5;
        if (var3 > 10){
            System.out.println("Var3 is greater than 10");
        } else {
            System.out.println("Var3 is less than 10");
        }
        




        //for this section: why are we not entering the if statement?
        //we are not entering the if statement because the first uppercase Letter in marist does not match
        if ("Marist" == "marist"){
            System.out.println("Marist college!");
        } else{
            System.out.println("Not marist college :(!");
        }
    }
    }




