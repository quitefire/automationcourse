package homework1_1;

/**
 * Created by Serhii Babenko on 30.05.2017.
 */
public class ParkingPlace {

    private int placeNumber;
    private Vehicle vehicle;
    private boolean free;

    /**
     *
     * @param placeNumber - place number
     * @param free - is this place free
     * @param vehicle - if free vehile default to null
     */
    public ParkingPlace(int placeNumber, boolean free, Vehicle vehicle){
        setVehicle(vehicle);
        setPlaceNumber(placeNumber);
        setFree(free);
    }
    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.setFree(false);
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

