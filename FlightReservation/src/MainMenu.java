import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

// commit test to see sync by josh ###########
public class MainMenu {

	public static void main(String[] args) throws InterruptedException {
		//Scanner scan = new Scanner(System.in);
		FlightDatabase flightDB = new FlightDatabase();
		ProgressBar progressBar = new ProgressBar();
		flightDB.initializeFlights();
		JOptionPane.showMessageDialog(null, "WELCOME TO OUR CS500 FLIGHT RESERVATION PROGRAM", " ",
				JOptionPane.PLAIN_MESSAGE);
		while (true) {
			// try-catch to avoid crashing at runtime
			try {
				//System.out.println("\nWELCOME TO CS-500 FLIGHT MANAGEMENT SYSTEM\n");
				String input = JOptionPane.showInputDialog(null, " \n Please choose an option \n 1. Search for flights\n 2. Add Passenger to Flight" +
						"\n 3. Delete passenger from flight\n 4. Display flight info for flight number", "Main Menu", JOptionPane.PLAIN_MESSAGE);

				if (input == null) {
					JOptionPane.showMessageDialog(null, "GoodBye!", " ", JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
				}
				else {
					int keyInt = Integer.parseInt(input);

					switch (keyInt) {
						case 1:
							progressBar.loadBar();
							String originAirportCode = JOptionPane.showInputDialog(null, " \n Enter 3 digit airport code for origin (Ex. ATL):", "Flight Info", JOptionPane.PLAIN_MESSAGE);

							if (originAirportCode == null) {
								break;
							}
							if (originAirportCode.length() == 0) {
								JOptionPane.showMessageDialog(null,
										"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
								break;
							}
							originAirportCode = originAirportCode.toUpperCase();
							String destinationAirportCode = JOptionPane.showInputDialog(null, " \n Enter 3 digit airport code for destination (Ex. MCO):", "Flight Info", JOptionPane.PLAIN_MESSAGE);

							if (destinationAirportCode == null) {
								break;
							}
							if (destinationAirportCode.length() == 0) {
								JOptionPane.showMessageDialog(null,
										"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
								break;
							}
							destinationAirportCode = destinationAirportCode.toUpperCase();

							ArrayList<Flight> matchedFlights = searchFlights(flightDB, originAirportCode, destinationAirportCode);
							if (matchedFlights.size() == 0) {
								JOptionPane.showMessageDialog(null, "No flights available", "ERROR", JOptionPane.ERROR_MESSAGE);

							} else {
								//System.out.println("Available Flights: ");
								//for (int i = 0; i < matchedFlights.size(); i++) {
								JOptionPane.showMessageDialog(null,  matchedFlights.get(0).getFlightNumber() + " "
										+ matchedFlights.get(0).getOrigin().getAirportName() + " -> "
										+ matchedFlights.get(0).getDestination().getAirportName() + " "
										+ matchedFlights.get(0).getDepartureTime()+ "\n" + matchedFlights.get(1).getFlightNumber() + " "
										+ matchedFlights.get(1).getOrigin().getAirportName() + " -> "
										+ matchedFlights.get(1).getDestination().getAirportName() + " "
										+ matchedFlights.get(1).getDepartureTime()+ "\n" + matchedFlights.get(2).getFlightNumber() + " "
										+ matchedFlights.get(2).getOrigin().getAirportName() + " -> "
										+ matchedFlights.get(2).getDestination().getAirportName() + " "
										+ matchedFlights.get(2).getDepartureTime()+ "\n" + matchedFlights.get(3).getFlightNumber() + " "
										+ matchedFlights.get(3).getOrigin().getAirportName() + " -> "
										+ matchedFlights.get(3).getDestination().getAirportName() + " "
										+ matchedFlights.get(3).getDepartureTime()+ "\n" + matchedFlights.get(4).getFlightNumber() + " "
										+ matchedFlights.get(4).getOrigin().getAirportName() + " -> "
										+ matchedFlights.get(4).getDestination().getAirportName() + " "
										+ matchedFlights.get(4).getDepartureTime(), "Available Flights", JOptionPane.PLAIN_MESSAGE);
										/*System.out.println("\t" + matchedFlights.get(i).getFlightNumber() + " "
												+ matchedFlights.get(i).getOrigin().getAirportName() + " -> "
												+ matchedFlights.get(i).getDestination().getAirportName() + " "
												+ matchedFlights.get(i).getDepartureTime());*/
							//}
					}



						break;
					case 2:
						progressBar.loadBar();
						String flightInput = JOptionPane.showInputDialog(null, "Enter flight number: ", "Flight Info", JOptionPane.PLAIN_MESSAGE);
						if (flightInput == null) { break; }
						if (flightInput.length() == 0) { JOptionPane.showMessageDialog(null,
								"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
							break; }
						int selectedFlightNumber = Integer.parseInt(flightInput);
						Flight selectedFlight = flightDB.getFlight(selectedFlightNumber);
						if (selectedFlight == null) {
							JOptionPane.showMessageDialog(null, "Flight number is not valid", "ERROR", JOptionPane.ERROR_MESSAGE);
							//System.out.println("Flight number is not valid");
							break;
						}
						JOptionPane.showMessageDialog(null, selectedFlight, " ", JOptionPane.PLAIN_MESSAGE);
						//System.out.println(selectedFlight);

						String seatInput = JOptionPane.showInputDialog(null, "Enter empty seat number: ", "Seat Info", JOptionPane.PLAIN_MESSAGE);
						if (seatInput == null) { break; }
						if (seatInput.length() == 0) { JOptionPane.showMessageDialog(null,
								"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
							break; }
						int selectedSeatNumber = Integer.parseInt(seatInput);
						Seat selectedSeat = selectedFlight.getPassengerSeat(selectedSeatNumber);
						if (selectedSeat != null && selectedSeat.isSeatAvailability()) {
							String nameEntered = JOptionPane.showInputDialog(null, "Enter name: ", "Passenger Info", JOptionPane.PLAIN_MESSAGE);
							if (nameEntered == null) { break; }
							if (nameEntered.length() == 0) { JOptionPane.showMessageDialog(null,
									"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
								break; }
							String addressEntered = JOptionPane.showInputDialog(null, "Enter address: ", "Passenger Info", JOptionPane.PLAIN_MESSAGE);
							if (addressEntered == null) { break; }
							if (addressEntered.length() == 0) { JOptionPane.showMessageDialog(null,
									"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
								break; }
							String phoneNumberEntered = JOptionPane.showInputDialog(null, "Enter phone number: ", "Passenger Info", JOptionPane.PLAIN_MESSAGE);
							if(phoneNumberEntered == null) { break; }
							if (phoneNumberEntered.length() == 0) { JOptionPane.showMessageDialog(null,
									"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
								break; }
							String idNumberEntered = JOptionPane.showInputDialog(null, "Enter id number: ", "Passenger Info", JOptionPane.PLAIN_MESSAGE);
							if(idNumberEntered == null) { break; }
							if (idNumberEntered.length() == 0) { JOptionPane.showMessageDialog(null,
									"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
								break; }
							Passenger userPassenger = new Passenger(nameEntered, addressEntered, phoneNumberEntered, idNumberEntered);
							JOptionPane.showMessageDialog(null, userPassenger + " added to flight", "", JOptionPane.PLAIN_MESSAGE);
							//System.out.println(userPassenger);
							selectedFlight.setPassengerSeat(userPassenger, selectedSeatNumber);
							//System.out.println("Added to flight number: " + selectedFlightNumber);
						} else {
							JOptionPane.showMessageDialog(null, "Seat is not available", "ERROR", JOptionPane.ERROR_MESSAGE);
							//System.out.println("Seat is not available");
						}
						break;
					case 3:
						progressBar.loadBar();
						flightInput = JOptionPane.showInputDialog(null, "Enter flight number: ", "Flight Info", JOptionPane.PLAIN_MESSAGE);
						if (flightInput == null) {
							break;
						}
						selectedFlightNumber = Integer.parseInt(flightInput);
						selectedFlight = flightDB.getFlight(selectedFlightNumber);
						if (selectedFlight == null) {
							JOptionPane.showMessageDialog(null, "Flight number is not valid", "ERROR", JOptionPane.ERROR_MESSAGE);
							//System.out.println("Flight number is not valid");
							break;
						}
						JOptionPane.showMessageDialog(null, selectedFlight, " ", JOptionPane.PLAIN_MESSAGE);
						//System.out.println(selectedFlight);
						seatInput = JOptionPane.showInputDialog(null, "Enter occupied seat number: ", "Seat Info", JOptionPane.PLAIN_MESSAGE);
						if (seatInput == null) { break; }
						if (seatInput.length() == 0) { JOptionPane.showMessageDialog(null,
								"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
							break; }
						selectedSeatNumber = Integer.parseInt(seatInput);
						selectedSeat = selectedFlight.getPassengerSeat(selectedSeatNumber);
						if (selectedSeat.isSeatAvailability()) {
							JOptionPane.showMessageDialog(null, "No passenger occupies seat number: " + selectedSeatNumber, " ", JOptionPane.PLAIN_MESSAGE);
							//System.out.println("No passenger occupies seat number: " + selectedSeatNumber);
						} else {
							JOptionPane.showMessageDialog(null, "Passenger Removed", "Flight Info",
									JOptionPane.PLAIN_MESSAGE);
							//System.out.println("Passenger removed from seat " + selectedSeatNumber);
							selectedFlight.deletePassenger(selectedSeatNumber);
						}
						break;
					case 4:
						progressBar.loadBar();
						flightInput = JOptionPane.showInputDialog(null, "Enter flight number: ", "Flight Info", JOptionPane.PLAIN_MESSAGE);
						if (flightInput == null) { break; }
						if (flightInput.length() == 0) {
							JOptionPane.showMessageDialog(null, "Invalid input", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							break; }
						selectedFlightNumber = Integer.parseInt(flightInput);
						selectedFlight = flightDB.getFlight(selectedFlightNumber);
						if (selectedFlight == null) {
							JOptionPane.showMessageDialog(null, "Flight number is not valid", "ERROR", JOptionPane.ERROR_MESSAGE);
							//System.out.println("Flight number is not valid");
							break;
						}
						JOptionPane.showMessageDialog(null, selectedFlight, " ", JOptionPane.PLAIN_MESSAGE);
						//System.out.println(selectedFlight);
						break;

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
