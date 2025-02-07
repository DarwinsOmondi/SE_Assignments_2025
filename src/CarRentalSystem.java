import java.util.Scanner;

public class CarRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalAgency agency = new RentalAgency();

        while (true) {
            System.out.println("\nCar Rental System");
            System.out.println("1. Add Car");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent Car");
            System.out.println("4. Return Car");
            System.out.println("5. Show Cars");
            System.out.println("6. Show Customers");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Car ID: ");
                    String carId = scanner.nextLine();
                    System.out.print("Enter Car Model: ");
                    String model = scanner.nextLine();
                    agency.addCar(new Car(carId, model));
                    System.out.println("Car added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    agency.addCustomer(new Customer(customerId, customerName));
                    System.out.println("Customer added successfully.");
                    break;

                case 3:
                    System.out.print("Enter Car ID to rent: ");
                    String rentCarId = scanner.nextLine();
                    System.out.print("Enter Customer ID: ");
                    String rentCustomerId = scanner.nextLine();
                    agency.rentCar(rentCarId, rentCustomerId);
                    break;

                case 4:
                    System.out.print("Enter Car ID to return: ");
                    String returnCarId = scanner.nextLine();
                    agency.returnCar(returnCarId);
                    break;

                case 5:
                    agency.showCars();
                    break;

                case 6:
                    agency.showCustomers();
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
