
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class CarRentalSystem {

    private ArrayList<Car> cars;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void storeNewCar(Car car) {
        cars.add(car);
    }

    public void storeCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isCarAvailable()) {
            car.rent();
            car.calculatePrice(days);
            Rental rental = new Rental(car, customer, days);
            rentals.add(rental);
        } else {
            System.out.println("Car is not available for rent.");

        }
    }

    public void returnCar(Car car) {
        Rental rentalCar = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalCar = rental;
                break;
            }
        }

        if (rentalCar != null) {
            rentals.remove(rentalCar);
            System.out.println("Car return successfully.");
        } else {
            System.out.println("Car was not return");
        }
    }

    public void menu() {
        Scanner input = new Scanner(System.in);
        Scanner carIdName = new Scanner(System.in);
        boolean condition = true;
        System.out.println();
        System.out.println("###########   Car Rent Management System   ###########");
        System.out.println();
        while (condition) {
            System.out.println("Press 1 to rent car");
            System.out.println("press 2 to return car");
            System.out.println("Press 3 to exit the process.");
            System.out.print("Press the number:   ");
            int select = input.nextInt();

            System.out.println();
            if (select == 1) {
                // Iterator<Car> car = cars.iterator();
                // while (car.hasNext()) {
                //     System.out.println(car.next());
                // }

                for (Car car : cars) {
                    System.out.println(car.toString());
                    System.out.println();
                }
                System.out.print("Enter car id that you want to rent:  ");
                String carId = carIdName.nextLine();

                Optional<Car> optionalCar = cars.stream()
                        .filter(car -> car.getCarId().equals(carId))
                        .findFirst();

                if (optionalCar.isPresent()) {
                    Car car = optionalCar.get();

                    System.out.print("Enter your name:  ");
                    String name = carIdName.nextLine();

                    System.out.print("Enter your Id:  ");
                    String customerId = carIdName.nextLine();

                    System.out.print("Enter number of days:  ");
                    int days = input.nextInt();
                    Customer customer = new Customer(customerId, name);
                    rentCar(car, customer, days);
                    System.out.println();
                    System.out.println("Car rent successfully. Here is details: ");

                    for (Rental rental : rentals) {
                        System.out.println(rental.toString());
                    }
                    System.out.println();
                } else {
                    System.out.println("Car not found with this id.");
                    System.out.println();
                }

            }

            // * RETURN CAR
            if (select == 2) {
                System.out.print("Enter car id that you return: ");
                String carId = carIdName.nextLine();
                for (Rental rental : rentals) {
                    if (rental.getCar().getCarId().equals(carId)) {
                        returnCar(rental.getCar());
                        System.out.println(rental.getCar().toString());
                        System.out.println();
                        break;
                    }
                }
            }
            if (select == 3) {
                condition = false;
            }
        }

    }

}
