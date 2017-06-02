package com.courses.homeworkTask2;

public class ParkingRun {

    public static void main(String args[]) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Boolean exit = false;
        int choice;
        Parking myParking = new Parking(10);

        myParking.addVehicleByPlaceNumber(0, new Motorcycle("Test", "0123455"));

        while (!exit) {

            System.out.println("\nEnter your choice \n");
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    //Park new Vehicle on last free place
                    System.out.println("Enter Model:");
                    String model = scanner.nextLine();
                    System.out.println("Enter plate number:");
                    String plateNumber = scanner.nextLine();
                    myParking.addVehicleOnLastFreePlace(new Motorcycle(model, plateNumber));
                    break;

                case 1:
                    //Park new Vehicle by place number
                    System.out.println("Enter place number:");
                    int placeNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Model:");
                    String model1 = scanner.nextLine();
                    System.out.println("Enter plate number:");
                    String plateNumber1 = scanner.nextLine();
                    myParking.addVehicleByPlaceNumber(placeNumber, new Motorcycle(model1, plateNumber1));
                    break;

                case 2:
                    //View all garage places
                    myParking.showAllVehiclesInGarage();
                    break;
                case 3:
                    //Search vehicle by place number
                    System.out.println("Enter place number:");
                    int searchNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(myParking.takeVehicleByPlaceNumber(searchNumber));
                    break;

                case 4:
                    //View last vehicle
                    System.out.println(myParking.takeLastVehicle());
                    break;
                case 5:
                    //Clear place by number
                    System.out.println("Enter place number:");
                    int placeToRemove = scanner.nextInt();
                    scanner.nextLine();
                    myParking.clearGaragePlaceByNumber(placeToRemove);
                    break;
                case 6:
                    //Clear all garage
                    myParking.clearAllGaragePlaces();
                    break;
                case 7:
                    //Update address
                    System.out.println("Enter new address:");
                    String newAddress = scanner.nextLine();
                    myParking.changeAddress(newAddress);
                    break;
                case 8:
                    //Open parking
                    myParking.open();
                    break;
                case 9 :
                    //Close parking
                    myParking.close();
                    break;
                case 10:
                    //Exit
                    exit = true;
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Enter 0 to park new Vehicle on last free place");
        System.out.println("Enter 1 to park new Vehicle by place number");
        System.out.println("Enter 2 to view all garage");
        System.out.println("Enter 3 to search vehicle by place number");
        System.out.println("Enter 4 to view last vehicle");
        System.out.println("Enter 5 to clear place by number");
        System.out.println("Enter 6 to clear all garage");
        System.out.println("Enter 7 to update address");
        System.out.println("Enter 8 to open parking");
        System.out.println("Enter 9 to close parking");
        System.out.println("Enter 10 to exit");
    }

}
