import java.util.ArrayList;
import java.util.List;


class Car {
    private String carId;
    private String model;
    private boolean isAvailable;

    public Car(String carId, String model) {
        this.carId = carId;
        this.model = model;
        this.isAvailable = true;
    }

    public String getCarId() { return carId; }
    public String getModel() { return model; }
    public boolean isAvailable() { return isAvailable; }

    public void rentCar() { this.isAvailable = false; }
    public void returnCar() { this.isAvailable = true; }

    @Override
    public String toString() {
        return "Car ID: " + carId + ", Model: " + model + ", Available: " + isAvailable;
    }
}

class Customer {
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
}

class RentalAgency {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public void addCar(Car car) { cars.add(car); }
    public void addCustomer(Customer customer) { customers.add(customer); }

    public void rentCar(String carId, String customerId) {
        Car car = findCar(carId);
        if (car != null && car.isAvailable()) {
            car.rentCar();
            System.out.println("Car " + carId + " rented to Customer " + customerId);
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    public void returnCar(String carId) {
        Car car = findCar(carId);
        if (car != null && !car.isAvailable()) {
            car.returnCar();
            System.out.println("Car " + carId + " returned.");
        } else {
            System.out.println("Invalid return operation.");
        }
    }

    private Car findCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId)) return car;
        }
        return null;
    }

    public void showCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void showCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
            return;
        }
        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getCustomerId() + ", Name: " + customer.getName());
        }
    }
}

