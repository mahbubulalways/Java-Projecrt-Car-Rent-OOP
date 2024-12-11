
public class Car {

    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId, String brand, String model, double basePricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double calculatePrice(int days) {
        return basePricePerDay * days;
    }

    public boolean isCarAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;

    }

    // to string
    @Override
    public String toString() {
        return "Car {" + "\n"
                + "car_id:  " + carId + "\n"
                + "brand:  " + brand + "\n"
                + "model:  " + model + "\n"
                + "rent_per_day:  " + basePricePerDay + "\n"
                + "Availability:  " + isAvailable + "\n"
                + "}";
    }
}
