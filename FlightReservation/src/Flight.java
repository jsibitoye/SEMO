import java.util.Date;

public class Flight {
	
	private int flightNumber;
	private Airport origin;
	private Airport destination;
	private Date departureTime;
	private Date arrivalTime;
	private Seat passengerSeat;
	
	Flight(int flightNumber, Airport origin, Airport destination, Date departureTime, Date arrivalTime, Seat passengerSeat) {
		
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
	
	public Seat getPassengerSeat() {
		return passengerSeat;
	}

	public void setPassengerSeat(Seat passengerSeat) {
		this.passengerSeat = passengerSeat;
	}
	
	public void bookFlight() {
		
	}
	
	public void cancelFlight() {
		
	}
	
	public String toString() {
		return "Flight number: " + flightNumber + "\nOriginating Airport: " + origin + "\nDestination Airport: " + destination + "\n" + departureTime + "/n" + arrivalTime;
	}
}
