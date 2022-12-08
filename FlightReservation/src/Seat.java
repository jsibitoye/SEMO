// This class contains seat number and passenger info
public class Seat {

	private int seatNumber;
	private Passenger passengerInfo;

	// Constructor
	Seat(int seatNumber) {
		this.seatNumber = seatNumber;
		this.passengerInfo = null;
	}

	// Accsessor methods
	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber; 
	}

	public boolean isSeatAvailability() {
		if (passengerInfo == null) {
			return true;
		}
		return false;
	}

	public Passenger getPassengerInfo() {
		return passengerInfo;
	}

	public void setPassengerInfo(Passenger passengerInfo) {
		this.passengerInfo = passengerInfo;
	}

	public String toString() {
		String returnString = "Seat" + " " + seatNumber + ":";
		if(passengerInfo == null) {
			returnString += " Empty";
		}
		else {
			returnString += " " + passengerInfo ;
		}
		return returnString;
	}
}
