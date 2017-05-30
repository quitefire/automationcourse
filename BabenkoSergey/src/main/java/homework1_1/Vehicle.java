package homework1_1;

/**
 * Created by Serhii Babenko on 30.05.2017.
 */
public abstract class Vehicle {
    private String model;
    private String  plateNumber;

    public Vehicle(String model, String plateNumber){
        setModel(model);
        setPlateNumber(plateNumber);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
