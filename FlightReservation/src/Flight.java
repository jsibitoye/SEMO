import java.util.Date;

public class Flight {

	private int flightNumber;
	private Airport origin;
	private Airport destination;
	private Date departureTime;
	private Date arrivalTime;
	private Seat[] passengerSeats;

	Flight(int flightNumber, Airport origin, Airport destination, Date departureTime, Date arrivalTime,int numOfSeats) {
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.passengerSeats = new Seat[numOfSeats];
		for(int i = 0; i<numOfSeats; i++) {
			this.passengerSeats[i] = new Seat(i);
		}
	}

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

	public Seat getPassengerSeat(int seatNumber) {
		return this.passengerSeats[seatNumber];
	}

	public void setPassengerSeat(Passenger passenger, int seatNumber) {
			if(passengerSeats[seatNumber].isSeatAvailability()) {
				passengerSeats[seatNumber].setPassengerInfo(passenger);
			}
			else {
				System.out.println("Seat is not availible");
			}
		}
	

	public void bookFlight() {

	}

	public void cancelFlight() {

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
