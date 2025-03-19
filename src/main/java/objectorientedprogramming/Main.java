package objectorientedprogramming;

public class Main {
    public static void main(String[] args) {
        // TODO
        //  - create 2 concrete classes: FuelCar and GasCar
        //  - the FuelCar must consume 1% of the total fuel (if tank capacity is 40 liters, consuption is 0.4 liters)
        //  - the GasCar must consume 5% of the gas
        //  - instantiate both and try calling method consumeFuel() and print values using System.out.println to check
        FuelCar fuelCar = new FuelCar((float) 0.2);
        System.out.println(fuelCar.consumeFuel());
        System.out.println(fuelCar.consumeFuel());
        System.out.println(fuelCar.consumeFuel());
        System.out.println(fuelCar.consumeFuel());
        System.out.println(fuelCar.consumeFuel());
        System.out.println(fuelCar.consumeFuel());
        System.out.println(fuelCar.consumeFuel());
        System.out.println(fuelCar.consumeFuel());
        System.out.println(fuelCar.consumeFuel());
        System.out.println(fuelCar.consumeFuel());
    }
}

