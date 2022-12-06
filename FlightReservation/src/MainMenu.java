import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

// commit test to see synch by josh ###########
public class MainMenu {

	public static void main(String[] args) throws InterruptedException {
		//Scanner scan = new Scanner(System.in);
		FlightDatabase flightDB = new FlightDatabase();
		ProgressBar progressBar = new ProgressBar();
		flightDB.initializeFlights();
		while (true) {
			// try-catch to avoid crashing at runtime
			try {
				System.out.println("\nWELCOME TO CS-500 FLIGHT MANAGEMENT SYSTEM\n");
				String input = JOptionPane.showInputDialog(" \n Please choose an option \n 1. Search for flights\n 2. Add Passenger to Flight" +
						"\n 3. Delete passenger from flight\n 4. Display flight info for flight number\n 5. Exit");

				if (input == null) {
					System.out.println("You have exited the program.");
					System.exit(0);
				}
				else {
					int keyInt = Integer.parseInt(input);

				switch (keyInt) {
					case 1:
						progressBar.loadBar();
						String originAirportCode = JOptionPane.showInputDialog(" \n Enter 3 digit airport code for origin (Ex. ATL):");
						if (originAirportCode == null) { break; }
						if (originAirportCode.length() == 0) { JOptionPane.showMessageDialog(null,
								"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
							break; }
						String destinationAirportCode = JOptionPane.showInputDialog(" \n Enter 3 digit airport code for destination (Ex. MCO):");
						if (destinationAirportCode == null) { break; }
						if (destinationAirportCode.length() == 0) { JOptionPane.showMessageDialog(null,
								"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
							break; }

								ArrayList<Flight> matchedFlights = searchFlights(flightDB, originAirportCode, destinationAirportCode);
								if (matchedFlights.size() == 0) {
									System.out.println("No flights available");
								}
								else {
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
						if (flightInput == null) { break; }
						if (flightInput.length() == 0) { JOptionPane.showMessageDialog(null,
								"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
							break; }
						if(flightInput.length() == 0 ) { break; }
						int selectedFlightNumber = Integer.parseInt(flightInput);
						Flight selectedFlight = flightDB.getFlight(selectedFlightNumber);
						if (selectedFlight == null) {
							System.out.println("Flight number is not valid");
							break;
						}
						System.out.println(selectedFlight);

						String seatInput = JOptionPane.showInputDialog("Enter empty seat number: ");
						if (seatInput == null) { break; }
						if (seatInput.length() == 0) { JOptionPane.showMessageDialog(null,
								"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
							break; }
						int selectedSeatNumber = Integer.parseInt(seatInput);
						Seat selectedSeat = selectedFlight.getPassengerSeat(selectedSeatNumber);
						if (selectedSeat != null && selectedSeat.isSeatAvailability()) {
							String nameEntered = JOptionPane.showInputDialog("Enter name: ");
							if (nameEntered == null) { break; }
							if (nameEntered.length() == 0) { JOptionPane.showMessageDialog(null,
									"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
								break; }
							String addressEntered = JOptionPane.showInputDialog("Enter address: ");
							if (addressEntered == null) { break; }
							if (addressEntered.length() == 0) { JOptionPane.showMessageDialog(null,
									"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
								break; }
							String phoneNumberEntered = JOptionPane.showInputDialog("Enter phone number: ");
							if(phoneNumberEntered == null) { break; }
							if (phoneNumberEntered.length() == 0) { JOptionPane.showMessageDialog(null,
									"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
								break; }

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
						flightInput = JOptionPane.showInputDialog("Enter flight number: ");
						if (flightInput == null) {
							break;
						}
						selectedFlightNumber = Integer.parseInt(flightInput);
						selectedFlight = flightDB.getFlight(selectedFlightNumber);
						if (selectedFlight == null) {
							System.out.println("Flight number is not valid");
							break;
						}
						System.out.println(selectedFlight);
						seatInput = JOptionPane.showInputDialog("Enter occupied seat number: ");
						if (seatInput == null) { break; }
						if (seatInput.length() == 0) { JOptionPane.showMessageDialog(null,
								"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
							break; }
						selectedSeatNumber = Integer.parseInt(seatInput);
						selectedSeat = selectedFlight.getPassengerSeat(selectedSeatNumber);
						if (selectedSeat.isSeatAvailability()) {
							System.out.println("No passenger occupies seat number: " + selectedSeatNumber);
						} else {
							System.out.println("Passenger removed from seat " + selectedSeatNumber);
							selectedFlight.deletePassenger(selectedSeatNumber);
						}
						break;
					case 4:
						progressBar.loadBar();
						flightInput = JOptionPane.showInputDialog("Enter flight number: ");
						if (flightInput == null) { break; }
						if (flightInput.length() == 0) {
							JOptionPane.showMessageDialog(null, "Invalid input", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							break; }
						selectedFlightNumber = Integer.parseInt(flightInput);
						selectedFlight = flightDB.getFlight(selectedFlightNumber);
						if (selectedFlight == null) {
							System.out.println("Flight number is not valid");
							break;
						}
						System.out.println(selectedFlight);
						break;
					case 5:
						System.out.println("You have exited the program");
						System.exit(5);
					default:
						JOptionPane.showMessageDialog(null, "Please enter the number of one of " +
								"the given options", "ERROR", JOptionPane.ERROR_MESSAGE);
						break;
				}

				}
			} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Invalid input", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			//System.out.println(" Invalid input !!! \n");
			//String errorLog = scan.next();
		}

		}

	}

	public static ArrayList<Flight> searchFlights(FlightDatabase flightDB, String originAirportCode,
			String destinationAirportCode) {
		return flightDB.getFlights(originAirportCode, destinationAirportCode);

	}

}
