import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GroceryListManager1 {
    private HashMap<String, Double> groceryList = new HashMap<>();

    public void addItem(String item, double cost) {
        groceryList.put(item, cost);
        System.out.println(item + " added to the list with cost " + cost);
    }

    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            groceryList.remove(item);
            System.out.println(item + " removed from the list.");
        } else {
            System.out.println(item + " not found in the list.");
        }
    }

    public void displayList() {
        System.out.println("\nGrocery List:");
        if (groceryList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            int i = 1;
            for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
                System.out.println(i + ". " + entry.getKey() + " - $" + entry.getValue());
                i++;
            }
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double total = 0.0;
        for (double cost : groceryList.values()) {
            total += cost;
        }
        return total;
    }

    public static void main(String[] args) {
        GroceryListManager1 manager = new GroceryListManager1();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Grocery List Manager ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display List");
            System.out.println("4. Check Item");
            System.out.println("5. Calculate Total Cost");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item to add: ");
                    String addItem = sc.nextLine();
                    System.out.print("Enter cost of " + addItem + ": ");
                    double cost = sc.nextDouble();
                    manager.addItem(addItem, cost);
                    break;
                case 2:
                    System.out.print("Enter item to remove: ");
                    String removeItem = sc.nextLine();
                    manager.removeItem(removeItem);
                    break;
                case 3:
                    manager.displayList();
                    break;
                case 4:
                    System.out.print("Enter item to check: ");
                    String checkItem = sc.nextLine();
                    System.out.println("Is \"" + checkItem + "\" in the grocery list? " + manager.checkItem(checkItem));
                    break;
                case 5:
                    System.out.println("Total cost of all items: $" + manager.calculateTotalCost());
                    break;
                case 6:
                    System.out.println("Exiting Grocery List Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}