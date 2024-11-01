import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    
    public static int calculateProfit(int fuelSold, int pricePerGallon, int operationalCosts, int variableCostsPerGallon) {
        int revenue = fuelSold * pricePerGallon;// total revenue
        int totalCosts = operationalCosts + (fuelSold * variableCostsPerGallon); // total costs
        return revenue - totalCosts; // profit
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> profits = new ArrayList<>();
        String continueInput = "yes";

        while (continueInput.equalsIgnoreCase("yes")) {
            System.out.print("Enter fuel sold (gallons): ");
            int fuelSold = scanner.nextInt();
            System.out.print("Enter price per gallon in cents");
            int pricePerGallon = scanner.nextInt();
            System.out.print("Enter operational costs in cents");
            int operationalCosts = scanner.nextInt();
            System.out.print("Enter variable costs per gallon in cents: ");
            int variableCostsPerGallon = scanner.nextInt();

            // Call the function
            int profit = calculateProfit(fuelSold, pricePerGallon, operationalCosts, variableCostsPerGallon);
            profits.add(profit); // Store

            System.out.print("Do you want to enter another day's sales? (yes/no): ");
            continueInput = scanner.next();
        }

        // Summary
        int totalProfit = 0;
        System.out.println("Daily Profit Summary:");
        for (int i = 0; i < profits.size(); i++) {
            totalProfit += profits.get(i);
            System.out.printf("Day %d Profit: %d cents", i + 1, profits.get(i)); 
        }
        System.out.printf("Total Profit: %d cents", totalProfit);

        scanner.close(); 
    }
}
