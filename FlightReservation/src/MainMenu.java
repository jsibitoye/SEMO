
		//switch case for Add New Flight, Delete a Flight, Book a Flight, Cancel a Flight, View Available Flights, View Passenger Info
		/*switch
		 * case0: run methods to create a new flight object and add it to data structure
		 * case1: run methods to delete a flight from database
		 * case2: run methods to create a passenger object and add to passenger database, then link with flight object in a database?
		 * case3: run methods to delete link between passenger object and flight object database?
		 * case4: run method to print all flight objects with corresponding info
		 * case5: run method to print all passenger objects with corresponding personal info
		 */
import java.util.ArrayList;
import java.util.Scanner;
// commit test to see synch by josh ###########
// line 2
public class MainMenu {

	public static void main(String[] args) {
		// switch case for Add New Flight, Delete a Flight, Book a Flight, Cancel a
		// Flight, View Available Flights, View Passenger Info
		FlightDatabase flightDB = new FlightDatabase();
		flightDB.initializeFlights();
		Scanner input = new Scanner(System.in);
		boolean exitFlag = false;
		while (exitFlag == false) {
			displayMenu();
			int keyInt = input.nextInt();
			switch (keyInt) {
			case 0:
				exitFlag = true;
				System.out.println("You have exited the program");
				break;
			case 1:
				System.out.print("Enter 3 digit airport code for origin (Ex.ATL): ");
				String originAirportCode = input.next();
				System.out.print("Enter 3 digit airport code for destination (Ex.MCO): ");
				String destinationAirportCode = input.next();

				ArrayList<Flight> matchedFlights = searchFlights(flightDB, originAirportCode, destinationAirportCode);
				if (matchedFlights.size() == 0) {
					System.out.println("No flights available");
				} else {
					System.out.println("Available Flights: ");
					for (int i = 0; i < matchedFlights.size(); i++) {
						System.out.println("\t" + matchedFlights.get(i).getFlightNumber() + " "
								+ matchedFlights.get(i).getOrigin().getAirportName() + " -> " 
								+ matchedFlights.get(i).getDestination().getAirportName()+ " " 
								+ matchedFlights.get(i).getDepartureTime());
					}
				}
				break;
			case 2:
				System.out.print("Enter flight number: ");
				int selectedFlightNumber = input.nextInt();
				Flight selectedFlight = flightDB.getFlight(selectedFlightNumber);
				System.out.println(selectedFlight);
				System.out.print("Enter empty seat number: ");
				int selectedSeatNumber = input.nextInt();
				input.nextLine();
				Seat selectedSeat = selectedFlight.getPassengerSeat(selectedSeatNumber);
				if (selectedSeat.isSeatAvailability()) {
					System.out.print("Enter Name: ");
					String nameEntered = input.nextLine();
					System.out.print("Enter Address: ");
					String addressEntered = input.nextLine();
					System.out.print("Enter Phone Number: ");
					String phoneNumberEntered = input.nextLine();

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
				selectedFlightNumber = input.nextInt();
				selectedFlight = flightDB.getFlight(selectedFlightNumber);
				System.out.println(selectedFlight);
				break;
			default:
				System.out.println("Input not recognized");

			}
		}

	}

	public static ArrayList<Flight> searchFlights(FlightDatabase flightDB, String originAirportCode,
			String destinationAirportCode) {
		return flightDB.getFlights(originAirportCode, destinationAirportCode);

	}

	public static void displayMenu() {
		System.out.println("Enter Menu Selection");
		System.out.println("\t0: Exit");
		System.out.println("\t1: Search for flights");
		System.out.println("\t2: Add passenger to flight");
		System.out.println("\t3: Display flight info for flight number");
	}
}
