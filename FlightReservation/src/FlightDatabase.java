import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FlightDatabase {

	private ArrayList<Flight> flights = new ArrayList<Flight>();

	public void addFlight(Flight flight) {
		flights.add(flight);
	}

	public void initializeFlights() {
		Airport origin1 = new Airport("Atlanta", "USA", "ATL");
		Airport destination1 = new Airport("Orlando", "USA", "MCO");
		Calendar myCal1 = Calendar.getInstance();
		myCal1.set(Calendar.YEAR, 2022);
		myCal1.set(Calendar.MONTH, 11);
		myCal1.set(Calendar.DAY_OF_MONTH, 22);
		myCal1.set(Calendar.HOUR, 8);
		myCal1.set(Calendar.MINUTE, 30);
		myCal1.set(Calendar.SECOND, 0);
		Date departureTime1 = myCal1.getTime();
		Date arrivalTime1 = myCal1.getTime();
		int numOfSeats = 40;
		for (int i = 0; i < 5; i++) {
			myCal1.set(Calendar.HOUR, i + 2);
			departureTime1 = myCal1.getTime();
			myCal1.set(Calendar.HOUR, i + 4);
			arrivalTime1 = myCal1.getTime();
			Flight flight1 = new Flight(80086 + i, origin1, destination1, departureTime1, arrivalTime1, numOfSeats);
			flights.add(flight1);
		}
		

		Airport origin2 = new Airport("Austin", "USA", "AUS");
		Airport destination2 = new Airport("Boston", "USA", "BOS");
		Calendar myCal2 = Calendar.getInstance();
		myCal2.set(Calendar.YEAR, 2022);
		myCal2.set(Calendar.MONTH, 11);
		myCal2.set(Calendar.DAY_OF_MONTH, 23);
		myCal2.set(Calendar.HOUR, 8);
		myCal2.set(Calendar.MINUTE, 30);
		myCal2.set(Calendar.SECOND, 0);
		Date departureTime2 = myCal2.getTime();
		Date arrivalTime2 = myCal2.getTime();
		for (int i = 0; i < 5; i++) {
			myCal2.set(Calendar.HOUR, i + 2);
			departureTime2 = myCal2.getTime();
			myCal2.set(Calendar.HOUR, i + 4);
			arrivalTime2 = myCal2.getTime();
			Flight flight2 = new Flight(8008135 + i, origin2, destination2, departureTime2, arrivalTime2, numOfSeats);
			flights.add(flight2);
		}
	}

	public ArrayList<Flight> getFlights(String originAirportName, String destinationAirportName) {
		ArrayList<Flight> matchedFlights = new ArrayList<Flight>();
		for (int i = 0; i < flights.size(); i++) {
			if (originAirportName.equals(flights.get(i).getOrigin().getAirportName())
					&& destinationAirportName.equals(flights.get(i).getDestination().getAirportName())) {
				matchedFlights.add(flights.get(i));
			}
		}
		return matchedFlights;

	}

	public void addPassenger(Passenger arbPass, int flightNumber, int seatNumber) {
		boolean seatFound = false;
		int i = 0;
		while (seatFound == false) {
			if (flightNumber == flights.get(i).getFlightNumber()) {
				flights.get(i).setPassengerSeat(arbPass, seatNumber);
				seatFound = true;
			}
			i += 1;
		}
	}

	public Flight getFlight(int flightNumber) {
		for (int i = 0; i < flights.size(); i++) {
			if (flightNumber == flights.get(i).getFlightNumber()) {
				return flights.get(i);
			}
		}
		return null;
	}
}
