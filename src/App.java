
public class App {

    public static void main(String[] args) throws Exception {
        CarRentalSystem carRentalSystem = new CarRentalSystem();
        Car c1 = new Car("c-001", "Honda", "Honda-0098", 2000);
        Car c2 = new Car("c-002", "Corolla", "Corolla-D698", 1200);
        Car c3 = new Car("c-003", "Primio", "Primio-P841", 2200);
        Car c4 = new Car("c-004", "Toyota", "Toyota-098", 1000);
        carRentalSystem.storeNewCar(c1);
        carRentalSystem.storeNewCar(c2);
        carRentalSystem.storeNewCar(c3);
        carRentalSystem.storeNewCar(c4);
        carRentalSystem.menu();
    }
}
