import java.util.ArrayList;
import java.util.Scanner;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        groceryList.add(item);
        System.out.println(item + " added to the list.");
    }

    public void removeItem(String item) {
        if (groceryList.remove(item)) {
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
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println((i + 1) + ". " + groceryList.get(i));
            }
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Grocery List Manager ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display List");
            System.out.println("4. Check Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item to add: ");
                    String addItem = sc.nextLine();
                    manager.addItem(addItem);
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
                    System.out.println("Exiting Grocery List Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}