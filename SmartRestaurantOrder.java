import java.util.Scanner;

public class SmartRestaurantOrder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Constants
        final double DRINK_PRICE = 15.50;
        final double STUDENT_DISCOUNT = 0.10;
        final double SENIOR_DISCOUNT = 0.05;
        final double TIP_RATE = 0.10;

        // Customer information
        String customerName;
        int customerAge;
        double mealPrice;
        int drinksQuantity;
        boolean isStudent;
        int serviceRating;

        // Bill calculations
        double drinksCost;
        double subtotal;
        double discountRate;
        double discountAmount;
        double amountAfterDiscount;
        double tipAmount;
        double finalBill;
        int wholeAmount;

        System.out.println("===== SMART RESTAURANT ORDER =====");

        // Get customer information
        System.out.print("Enter customer name: ");
        customerName = input.nextLine();

        System.out.print("Enter customer age: ");
        customerAge = input.nextInt();

        System.out.print("Enter meal price: $");
        mealPrice = input.nextDouble();

        System.out.print("Enter number of drinks: ");
        drinksQuantity = input.nextInt();

        System.out.print("Is the customer a student? (true/false): ");
        isStudent = input.nextBoolean();

        System.out.print("Enter service rating (1-5): ");
        serviceRating = input.nextInt();

        // Validate service rating
        if (serviceRating < 1 || serviceRating > 5) {
            System.out.println("Error: Service rating must be between 1 and 5.");
        } else {
            // Calculate drinks cost and subtotal
            drinksCost = drinksQuantity * DRINK_PRICE;
            subtotal = mealPrice + drinksCost;

            // Select the applicable discount
            if (isStudent && customerAge >= 60) {
                discountRate = STUDENT_DISCOUNT;
            } else if (isStudent) {
                discountRate = STUDENT_DISCOUNT;
            } else if (customerAge >= 60) {
                discountRate = SENIOR_DISCOUNT;
            } else {
                discountRate = 0.0;
            }

            // Calculate discount
            discountAmount = subtotal * discountRate;
            amountAfterDiscount = subtotal - discountAmount;

            // Calculate tip
            if (serviceRating == 4 || serviceRating == 5) {
                tipAmount = amountAfterDiscount * TIP_RATE;
            } else {
                tipAmount = 0.0;
            }

            // Calculate final bill and cast to int
            finalBill = amountAfterDiscount + tipAmount;
            wholeAmount = (int) finalBill;

            // Print receipt
            System.out.println("\n========== SMART RESTAURANT ==========");
            System.out.println("Customer: " + customerName);
            System.out.printf("Meal: $%.2f%n", mealPrice);
            System.out.printf("Drinks: $%.2f%n", drinksCost);
            System.out.printf("Discount: $%.2f%n", discountAmount);
            System.out.printf("Tip: $%.2f%n", tipAmount);
            System.out.printf("Exact final bill: $%.2f%n", finalBill);
            System.out.println("Whole amount: $" + wholeAmount);
            System.out.println("======================================");
        }

        input.close();
    }
}