/*import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI {
    public static void main(String[] args) {
        while (true) {
            FlightDatabase flightDB = new FlightDatabase();
            flightDB.initializeFlights();
            Scanner scan = new Scanner(System.in);
            String output = " ";
            String input = JOptionPane.showInputDialog(" \n Please choose an option" + "\n 1. Search for flights" +
                    "\n 2. Add Passenger to Flight" + "\n 3. Delete passenger from flight" +
                    "\n 4. Display flight info for flight number");
            int in = Integer.parseInt(input);

            switch (in) {
                case 0:
                    System.exit(0);
                case 1:
                    String origin = JOptionPane.showInputDialog(" \n Enter 3 digit airport code for origin (Ex. ATL):");
                    String destination = JOptionPane.showInputDialog(" \n Enter 3 digit airport code for destination (Ex. MCO):");

                    ArrayList<Flight> matchedFlights = searchFlights(flightDB, origin, destination);
                    if (matchedFlights.size() == 0) {
                        System.out.println("No flights available");
                    } else {
                        System.out.println("Available Flights: ");
                        for (int i = 0; i < matchedFlights.size(); i++) {
                            System.out.println("\t" + matchedFlights.get(i).getFlightNumber() + " "
                                    + matchedFlights.get(i).getOrigin().getAirportName() + " -> "
                                    + matchedFlights.get(i).getDestination().getAirportName() + " "
                                    + matchedFlights.get(i).getDepartureTime());
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter flight number: ");
                    int selectedFlightNumber = scan.nextInt();
                    Flight selectedFlight = flightDB.getFlight(selectedFlightNumber);
                    if (selectedFlight == null) {
                        System.out.println("Flight number is not valid");
                        break;
                    }
                    System.out.println(selectedFlight);

                    System.out.print("Enter empty seat number: ");
                    int selectedSeatNumber = scan.nextInt();
                    scan.nextLine();
                    Seat selectedSeat = selectedFlight.getPassengerSeat(selectedSeatNumber);
                    if (selectedSeat != null && selectedSeat.isSeatAvailability()) {
                        System.out.print("Enter Name: ");
                        String nameEntered = scan.nextLine();
                        System.out.print("Enter Address: ");
                        String addressEntered = scan.nextLine();
                        System.out.print("Enter Phone Number: ");
                        String phoneNumberEntered = scan.nextLine();

                        Passenger userPassenger = new Passenger(nameEntered, addressEntered, phoneNumberEntered);
                        System.out.println(userPassenger);
                        selectedFlight.setPassengerSeat(userPassenger, selectedSeatNumber);
                        System.out.println("Added to flight number: " + selectedFlightNumber);
                    } else {
                        System.out.println("Seat is not available");
                    }
                    break;
                case 3:
                    System.out.print("Enter flight number: ");
                    selectedFlightNumber = scan.nextInt();
                    selectedFlight = flightDB.getFlight(selectedFlightNumber);
                    if (selectedFlight == null) {
                        System.out.println("Flight number is not valid");
                        break;
                    }
                    System.out.println(selectedFlight);
                    System.out.print("Enter occupied seat number: ");
                    selectedSeatNumber = scan.nextInt();
                    scan.nextLine();
                    selectedSeat = selectedFlight.getPassengerSeat(selectedSeatNumber);
                    if (selectedSeat.isSeatAvailability()) {
                        System.out.println("No passenger occupies seat number: " + selectedSeatNumber);
                    } else {
                        selectedFlight.deletePassenger(selectedSeatNumber);
                    }
                    break;
                case 4:
                    System.out.print("Enter flight number: ");
                    selectedFlightNumber = scan.nextInt();
                    selectedFlight = flightDB.getFlight(selectedFlightNumber);
                    if (selectedFlight == null) {
                        System.out.println("Flight number is not valid");
                        break;
                    }
                    System.out.println(selectedFlight);
                    break;

                default:
                    System.out.println("Input not recognized!!! \n");

            }

        }
    }

        public static ArrayList<Flight> searchFlights (FlightDatabase flightDB, String originAirportCode,
                String destinationAirportCode){
            return flightDB.getFlights(originAirportCode, destinationAirportCode);

        }
    }
*/