package homework1_1;

/**
 * Created by Serhii Babenko on 30.05.2017.
 */
public class ParkingPlace {

    private int placeNumber;
    private Vehicle vehicle;
    private boolean isFree;

    /**
     *
     * @param placeNumber - place number
     * @param isFree - is this place isFree
     * @param vehicle - if isFree vehile default to null
     */
    public ParkingPlace(int placeNumber, boolean isFree, Vehicle vehicle){
        setVehicle(vehicle);
        this.placeNumber = placeNumber;
        this.isFree = isFree;
    }
    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isFree = false;
    }

    public void setPlaceFree() {
        this.vehicle = null;
        this.setFree(true);
    }
    
    @Override
    public String toString() {
        String status = isFree()? "empty": "busy";

        return this.isFree() ? ("Place number " + placeNumber+"; Status: "+status) :
                ("Place number " + placeNumber + "; Vehicle: " + vehicle.getModel() + " " + vehicle.getPlateNumber()+"; Status: "+status);

    }




}

