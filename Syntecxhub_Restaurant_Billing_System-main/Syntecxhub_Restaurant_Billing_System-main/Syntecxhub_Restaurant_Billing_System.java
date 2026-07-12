import java.util.*;

class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class Syntecxhub_Restaurant_Billing_System {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<MenuItem> menu = new ArrayList<>();

    public static void main(String[] args) {

        // Default Menu
        menu.add(new MenuItem("Burger", 120));
        menu.add(new MenuItem("Pizza", 250));
        menu.add(new MenuItem("Pasta", 180));
        menu.add(new MenuItem("Cold Drink", 60));

        while (true) {
            System.out.println("\n===== RESTAURANT BILLING SYSTEM =====");
            System.out.println("1. Display Menu");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Remove Menu Item");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayMenu();
                    break;

                case 2:
                    addMenuItem();
                    break;

                case 3:
                    removeMenuItem();
                    break;

                case 4:
                    generateBill();
                    break;

                case 5:
                    System.out.println("Thank you! Visit Again.");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void displayMenu() {
        System.out.println("\n------ MENU ------");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " +
                    menu.get(i).name + " - Rs." +
                    menu.get(i).price);
        }
    }

    static void addMenuItem() {
        sc.nextLine();

        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        menu.add(new MenuItem(name, price));

        System.out.println("Item Added Successfully!");
    }

    static void removeMenuItem() {

        displayMenu();

        System.out.print("Enter Item Number to Remove: ");
        int index = sc.nextInt();

        if (index > 0 && index <= menu.size()) {
            System.out.println(menu.get(index - 1).name +
                    " Removed Successfully!");
            menu.remove(index - 1);
        } else {
            System.out.println("Invalid Item Number!");
        }
    }

    static void generateBill() {

        displayMenu();

        double subtotal = 0;

        ArrayList<String> billItems = new ArrayList<>();

        while (true) {

            System.out.print("\nEnter Item Number (0 to finish): ");
            int itemNo = sc.nextInt();

            if (itemNo == 0)
                break;

            if (itemNo < 1 || itemNo > menu.size()) {
                System.out.println("Invalid Item!");
                continue;
            }

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            MenuItem item = menu.get(itemNo - 1);

            double amount = item.price * qty;
            subtotal += amount;

            billItems.add(item.name + "\t" +
                    qty + "\tRs." + amount);
        }

        double gst = subtotal * 0.05;
        double total = subtotal + gst;

        System.out.println("\n=================================");
        System.out.println("          ITEMIZED RECEIPT");
        System.out.println("=================================");
        System.out.println("Item\tQty\tAmount");

        for (String item : billItems) {
            System.out.println(item);
        }

        System.out.println("---------------------------------");
        System.out.printf("Subtotal : Rs. %.2f\n", subtotal);
        System.out.printf("GST (5%%) : Rs. %.2f\n", gst);
        System.out.printf("Total Bill : Rs. %.2f\n", total);
        System.out.println("=================================");
    }
}