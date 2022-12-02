import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FlightDatabase {

	private ArrayList<Flight> availableFlights = new ArrayList<>();

	public void addFlight(Flight flight) {
		}

	public void initializeFlights() {
		Airport austin = new Airport("Austin", "USA", "AUS");
		Airport boston = new Airport("Boston", "USA", "BOS");
		Airport atlanta = new Airport("Atlanta", "USA", "ATL");
		Airport orlando = new Airport("Orlando", "USA", "MCO");
		Passenger[] fakePassengers = new Passenger[4];
		fakePassengers[0] = new Passenger("Ricky Bobby", "1 Fast st", "3216964587");
		fakePassengers[1] = new Passenger("Tyler Blankenship", "2 Fast st", "3216964588");
		fakePassengers[2] = new Passenger("Indranil Roy", "3 Fast st", "3216964589");
		fakePassengers[3] = new Passenger("Ethan Chou", "4 Fast st", "3216964586");
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2022);
		myCal.set(Calendar.MONTH, 11);
		myCal.set(Calendar.DAY_OF_MONTH, 22);
		myCal.set(Calendar.HOUR, 8);
		myCal.set(Calendar.MINUTE, 30);
		myCal.set(Calendar.SECOND, 0);
		Date departureTime;
		Date arrivalTime;
		int numOfSeats = 10;

		for (int i = 0; i < 5; i++) {
			myCal.set(Calendar.HOUR, i + 2);
			departureTime = myCal.getTime();
			myCal.set(Calendar.HOUR, i + 4);
			arrivalTime = myCal.getTime();
			Flight flight1 = new Flight(80086 + i, austin, boston, departureTime, arrivalTime, numOfSeats);
			for( int j = 0; j < fakePassengers.length; j++ ) {
				flight1.setPassengerSeat(fakePassengers[j], j + 1);
			}
			availableFlights.add(flight1); }

		for (int i = 0; i < 5; i++) {
			myCal.set(Calendar.HOUR, i + 2);
			departureTime = myCal.getTime();
			myCal.set(Calendar.HOUR, i + 3);
			arrivalTime = myCal.getTime();
			Flight flight2 = new Flight(80076 + i, orlando, atlanta, departureTime, arrivalTime, numOfSeats);
			for( int j = 0; j < fakePassengers.length; j++ ) {
				flight2.setPassengerSeat(fakePassengers[j], j + 1);
			}
			availableFlights.add(flight2); }

		for (int i = 0; i < 5; i++) {
			myCal.set(Calendar.HOUR, i + 2);
			departureTime = myCal.getTime();
			myCal.set(Calendar.HOUR, i + 3);
			arrivalTime = myCal.getTime();
			Flight flight3 = new Flight(80066 + i, atlanta, orlando, departureTime, arrivalTime, numOfSeats);
			for( int j = 0; j < fakePassengers.length; j++ ) {
				flight3.setPassengerSeat(fakePassengers[j], j + 1);
			}
			availableFlights.add(flight3);
		}

		for (int i = 0; i < 5; i++) {
			myCal.set(Calendar.HOUR, i + 2);
			departureTime = myCal.getTime();
			myCal.set(Calendar.HOUR, i + 4);
			arrivalTime = myCal.getTime();
			Flight flight4 = new Flight(80056 + i, boston, austin, departureTime, arrivalTime, numOfSeats);
			for( int j = 0; j < fakePassengers.length; j++ ) {
				flight4.setPassengerSeat(fakePassengers[j], j + 1);
			}
			availableFlights.add(flight4);
		}

	}

	public ArrayList<Flight> getFlights(String originAirportName, String destinationAirportName) {
		ArrayList<Flight> matchedFlights = new ArrayList<>();
		for (int i = 0; i < availableFlights.size(); i++) {
			if (originAirportName.equals(availableFlights.get(i).getOrigin().getAirportName())
					&& destinationAirportName.equals(availableFlights.get(i).getDestination().getAirportName())) {
				matchedFlights.add(availableFlights.get(i));
			}
		}
		return matchedFlights;

	}
	//unused method
	/*public void addPassenger(Passenger arbPass, int flightNumber, int seatNumber) {
		boolean seatFound = false;
		int i = 0;
		while (seatFound == false) {
			if (flightNumber == flights.get(i).getFlightNumber()) {
				flights.get(i).setPassengerSeat(arbPass, seatNumber);
				seatFound = true;
			}
			i += 1;
		}
	}*/
	public Flight getFlight(int flightNumber) {
		for (int i = 0; i < availableFlights.size(); i++) {
			if (flightNumber == availableFlights.get(i).getFlightNumber()) {
				return availableFlights.get(i);
			}
		}
		return null;
	}
}
