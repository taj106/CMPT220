import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    // Function to calculate profit
    public static int calculateProfit(int fuelSold, int pricePerGallon, int operationalCosts, int variableCostsPerGallon) {
        int revenue = fuelSold * pricePerGallon; // Calculate total revenue
        int totalCosts = operationalCosts + (fuelSold * variableCostsPerGallon); // Calculate total costs
        return revenue - totalCosts; // Return profit
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> profits = new ArrayList<>();
        String continueInput = "yes"; // Initialize to enter the loop

        while (continueInput.equalsIgnoreCase("yes")) {
            System.out.print("Enter fuel sold (gallons): ");
            int fuelSold = scanner.nextInt();
            System.out.print("Enter price per gallon (in cents): ");
            int pricePerGallon = scanner.nextInt();
            System.out.print("Enter operational costs (in cents): ");
            int operationalCosts = scanner.nextInt();
            System.out.print("Enter variable costs per gallon (in cents): ");
            int variableCostsPerGallon = scanner.nextInt();

            // Call the function to calculate profit
            int profit = calculateProfit(fuelSold, pricePerGallon, operationalCosts, variableCostsPerGallon);
            profits.add(profit); // Store the profit for this day

            System.out.print("Do you want to enter another day's sales? (yes/no): ");
            continueInput = scanner.next(); // Check if user wants to continue
        }

        // Summary of profits
        int totalProfit = 0;
        System.out.println("\nDaily Profit Summary:");
        for (int i = 0; i < profits.size(); i++) {
            totalProfit += profits.get(i); // Sum up total profits
            System.out.printf("Day %d Profit: %d cents\n", i + 1, profits.get(i)); // Display profit for each day
        }
        System.out.printf("Total Profit: %d cents\n", totalProfit); // Display total profit

        scanner.close(); // Close the scanner
    }
}
