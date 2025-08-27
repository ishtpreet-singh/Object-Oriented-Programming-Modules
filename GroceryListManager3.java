import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Item {
    String name;
    double cost;
    String category;
    int quantity;

    Item(String name, double cost, String category, int quantity) {
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.quantity = quantity;
    }
}

public class GroceryListManager3 {
    private HashMap<String, Item> groceryList = new HashMap<>();

    public void addItem(String name, double cost, String category, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be positive. Item not added.");
            return;
        }

        if (groceryList.containsKey(name)) {
            Item existing = groceryList.get(name);
            existing.quantity += quantity;
            System.out.println(name + " already exists. Updated quantity to " + existing.quantity);
        } else {
            groceryList.put(name, new Item(name, cost, category, quantity));
            System.out.println(name + " added with cost $" + cost + ", category " + category + ", quantity " + quantity);
        }
    }

    public void updateQuantity(String name, int newQuantity) {
        if (!groceryList.containsKey(name)) {
            System.out.println(name + " not found in the list.");
            return;
        }

        if (newQuantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return;
        }

        groceryList.get(name).quantity = newQuantity;
        System.out.println("Updated quantity of " + name + " to " + newQuantity);
    }

    public void removeItem(String name) {
        if (groceryList.containsKey(name)) {
            groceryList.remove(name);
            System.out.println(name + " removed from the list.");
        } else {
            System.out.println(name + " not found in the list.");
        }
    }

    public void displayList() {
        System.out.println("\nGrocery List:");
        if (groceryList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            int i = 1;
            for (Item item : groceryList.values()) {
                System.out.println(i + ". " + item.name + " - $" + item.cost + " (" + item.category + ") Quantity: " + item.quantity);
                i++;
            }
        }
    }

    public void displayAvailableItems() {
        System.out.println("\nAvailable Items (Quantity > 0):");
        int i = 1;
        boolean found = false;
        for (Item item : groceryList.values()) {
            if (item.quantity > 0) {
                System.out.println(i + ". " + item.name + " - $" + item.cost + " (" + item.category + ") Quantity: " + item.quantity);
                i++;
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items with positive quantity available.");
        }
    }

    public boolean checkItem(String name) {
        return groceryList.containsKey(name);
    }

    public double calculateTotalCost() {
        double total = 0.0;
        for (Item item : groceryList.values()) {
            total += item.cost * item.quantity;
        }
        return total;
    }

    public void displayByCategory(String category) {
        System.out.println("\nItems in category: " + category);
        int i = 1;
        boolean found = false;
        for (Item item : groceryList.values()) {
            if (item.category.equalsIgnoreCase(category)) {
                System.out.println(i + ". " + item.name + " - $" + item.cost + " Quantity: " + item.quantity);
                i++;
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found in this category.");
        }
    }

    public static void main(String[] args) {
        GroceryListManager3 manager = new GroceryListManager3();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Grocery List Manager ---");
            System.out.println("1. Add Item");
            System.out.println("2. Update Quantity");
            System.out.println("3. Remove Item");
            System.out.println("4. Display List");
            System.out.println("5. Display Available Items");
            System.out.println("6. Check Item");
            System.out.println("7. Calculate Total Cost");
            System.out.println("8. Display By Category");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter cost of " + name + ": ");
                    double cost = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter category of " + name + ": ");
                    String category = sc.nextLine();
                    System.out.print("Enter quantity of " + name + ": ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    manager.addItem(name, cost, category, quantity);
                    break;
                case 2:
                    System.out.print("Enter item name to update quantity: ");
                    String updateName = sc.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = sc.nextInt();
                    sc.nextLine();
                    manager.updateQuantity(updateName, newQuantity);
                    break;
                case 3:
                    System.out.print("Enter item name to remove: ");
                    String removeName = sc.nextLine();
                    manager.removeItem(removeName);
                    break;
                case 4:
                    manager.displayList();
                    break;
                case 5:
                    manager.displayAvailableItems();
                    break;
                case 6:
                    System.out.print("Enter item name to check: ");
                    String checkName = sc.nextLine();
                    System.out.println("Is \"" + checkName + "\" in the grocery list? " + manager.checkItem(checkName));
                    break;
                case 7:
                    System.out.println("Total cost of all items: $" + manager.calculateTotalCost());
                    break;
                case 8:
                    System.out.print("Enter category to display: ");
                    String cat = sc.nextLine();
                    manager.displayByCategory(cat);
                    break;
                case 9:
                    System.out.println("Exiting Grocery List Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 9);

        sc.close();
    }
}