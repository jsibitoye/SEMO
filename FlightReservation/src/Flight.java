import java.util.Date;

// This class defines a flight 
public class Flight {

	private int flightNumber;
	private Airport origin;
	private Airport destination;
	private Date departureTime;
	private Date arrivalTime;
	private Seat[] passengerSeats;

	//Constructor
	Flight(int flightNumber, Airport origin, Airport destination, Date departureTime, Date arrivalTime, int numOfSeats) {
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.passengerSeats = new Seat[numOfSeats];
		for(int i = 0; i<numOfSeats; i++) {
			this.passengerSeats[i] = new Seat(i +1);
		}
	}

	// Accsessor methods
	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Airport getOrigin() {
		return origin;
	}

	public void setOrigin(Airport origin) {
		this.origin = origin;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	// This method returns null if seat number is not valid
	public Seat getPassengerSeat(int seatNumber) {
		if(seatNumber > passengerSeats.length || seatNumber < 1) {
			return null;
		}
		return this.passengerSeats[seatNumber-1];
	}

	// This method logs warning if seat is not available 
	public void setPassengerSeat(Passenger passenger, int seatNumber) {
		if(passengerSeats[seatNumber-1].isSeatAvailability()) {
			passengerSeats[seatNumber-1].setPassengerInfo(passenger);
		}
		else {
			System.out.println("Seat is not available");
		}
	} 
	
	// This method logs warning if you try to delete a empty seat
	public void deletePassenger(int seatNumber) {
		if(passengerSeats[seatNumber-1].isSeatAvailability()) {
			System.out.println("No passenger occupies seat number: " + seatNumber);
		}
		else {
			passengerSeats[seatNumber-1].setPassengerInfo(null);
		}
	}

	public String toString() {
		String returnString = "Flight number: " + flightNumber + "\nOriginating Airport: " + origin + "\nDestination Airport: "
				+ destination + "\n" + departureTime + "\n" + arrivalTime + "\n";
		for(int i = 0; i<passengerSeats.length;i++) {
			returnString += passengerSeats[i].toString() + "\n";

		}
		return returnString;
	}
}
