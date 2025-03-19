package objectorientedprogramming;

public class FuelCar extends Car {

    private float porcentajeDeCombustibleDisponible;

    public FuelCar(float empiezamosCon) {
        porcentajeDeCombustibleDisponible = empiezamosCon;
    }

    @Override
    public float consumeFuel() {
        porcentajeDeCombustibleDisponible = (float) (porcentajeDeCombustibleDisponible - 0.01);
        return porcentajeDeCombustibleDisponible;
    }
}
