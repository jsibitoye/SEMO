import java.util.*;

public class MainDriver {

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
				System.out.println("Enter 3 digit airport code for origin: Ex.ATL ");
				String originAirportCode = input.next();
				System.out.println("Enter 3 digit airport code for destination: Ex.MCO ");
				String destinationAirportCode = input.next();

				ArrayList<Flight> matchedFlights = searchFlights(flightDB, originAirportCode, destinationAirportCode);
				if (matchedFlights.size() == 0) {
					System.out.println("No flights available");
				} else {
					System.out.println("Enter flight number: ");

					for (int i = 0; i < matchedFlights.size(); i++) {
						System.out.println("\t" + matchedFlights.get(i).getFlightNumber() +
								" " + matchedFlights.get(i).getOrigin().getAirportName() + 
								" -> " + matchedFlights.get(i).getDestination().getAirportName());
					}
					int selectedFlightNumber = input.nextInt();
					Flight selectedFlight = flightDB.getFlight(selectedFlightNumber);
					System.out.println(selectedFlight);
					System.out.println("Enter empty seat number: ");
					int selectedSeatNumber = input.nextInt();
					Seat selectedSeat = selectedFlight.getPassengerSeat(selectedSeatNumber);
					if(selectedSeat.isSeatAvailability()) {
						System.out.print("Enter Name: ");
						String nameEntered = input.next();
						System.out.print("Enter Phone Number: ");
						String phoneNumberEntered = input.next();
						System.out.print("Enter Address: ");
						String addressEntered = input.next();
						
						Passenger userPassenger = new Passenger(nameEntered,addressEntered,phoneNumberEntered);
						System.out.println(userPassenger);
						selectedFlight.setPassengerSeat(userPassenger,selectedSeatNumber);
						System.out.println(selectedFlight);
					}
					else {
						System.out.println("Seat is not available");
					}
				}
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
	}
}

