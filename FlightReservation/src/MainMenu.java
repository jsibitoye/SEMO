import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

// commit test to see synch by josh ###########
public class MainMenu {

	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		FlightDatabase flightDB = new FlightDatabase();
		ProgressBar progressBar = new ProgressBar();
		flightDB.initializeFlights();
		while (true) {
			// try-catch to avoid crashing at runtime
			try {
				System.out.println("\nWELCOME TO CS-500 FLIGHT MANAGEMENT SYSTEM\n");
				String input = JOptionPane.showInputDialog(" \n Please choose an option" + "\n 1. Search for flights" +
						"\n 2. Add Passenger to Flight" + "\n 3. Delete passenger from flight" +
						"\n 4. Display flight info for flight number");
				int keyInt = Integer.parseInt(input);

				switch (keyInt) {
					case 0:
						System.exit(0);
					case 1:
						progressBar.loadBar();
						String originAirportCode = JOptionPane.showInputDialog(" \n Enter 3 digit airport code for origin (Ex. ATL):");
						String destinationAirportCode = JOptionPane.showInputDialog(" \n Enter 3 digit airport code for destination (Ex. MCO):");

						ArrayList<Flight> matchedFlights = searchFlights(flightDB, originAirportCode, destinationAirportCode);
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
						progressBar.loadBar();
						String flightInput = JOptionPane.showInputDialog("Enter flight number: ");
						int selectedFlightNumber = Integer.parseInt(flightInput);
						Flight selectedFlight = flightDB.getFlight(selectedFlightNumber);
						if (selectedFlight == null) {
							System.out.println("Flight number is not valid");
							break;
						}
						System.out.println(selectedFlight);

						String seatInput = JOptionPane.showInputDialog("Enter empty seat number: ");
						int selectedSeatNumber = Integer.parseInt(seatInput);
						Seat selectedSeat = selectedFlight.getPassengerSeat(selectedSeatNumber);
						if (selectedSeat != null && selectedSeat.isSeatAvailability()) {
							String nameEntered = JOptionPane.showInputDialog("Enter name: ");
							String addressEntered = JOptionPane.showInputDialog("Enter address: ");
							String phoneNumberEntered = JOptionPane.showInputDialog("Enter phone number: ");

							Passenger userPassenger = new Passenger(nameEntered, addressEntered, phoneNumberEntered);
							System.out.println(userPassenger);
							selectedFlight.setPassengerSeat(userPassenger, selectedSeatNumber);
							System.out.println("Added to flight number: " + selectedFlightNumber);
						} else {
							System.out.println("Seat is not available");
						}
						break;
					case 3:
						progressBar.loadBar();
						String flightInput2 = JOptionPane.showInputDialog("Enter flight number: ");
						int selectedFlightNumber2 = Integer.parseInt(flightInput2);
						selectedFlight = flightDB.getFlight(selectedFlightNumber2);
						if (selectedFlight == null) {
							System.out.println("Flight number is not valid");
							break;
						}
						System.out.println(selectedFlight);
						String seatInput2 = JOptionPane.showInputDialog("Enter occupied seat number: ");
						int selectedSeatNumber2 = Integer.parseInt(seatInput2);
						selectedSeat = selectedFlight.getPassengerSeat(selectedSeatNumber2);
						if (selectedSeat.isSeatAvailability()) {
							System.out.println("No passenger occupies seat number: " + selectedSeatNumber2);
						} else {
							selectedFlight.deletePassenger(selectedSeatNumber2);
						}
						break;
					case 4:
						progressBar.loadBar();
						String flightInput3 = JOptionPane.showInputDialog("Enter flight number: ");
						int selectedFlightNumber3 = Integer.parseInt(flightInput3);
						selectedFlight = flightDB.getFlight(selectedFlightNumber3);
						if (selectedFlight == null) {
							System.out.println("Flight number is not valid");
							break;
						}
						System.out.println(selectedFlight);
						break;

					default:
						System.out.println("Input not recognized!!! \n");

				}
			} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" Invalid input !!! \n");
			String errorLog = scan.next();
		}

		}

	}

	public static ArrayList<Flight> searchFlights(FlightDatabase flightDB, String originAirportCode,
			String destinationAirportCode) {
		return flightDB.getFlights(originAirportCode, destinationAirportCode);

	}

}
