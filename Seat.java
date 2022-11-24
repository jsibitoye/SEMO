
public class Seat {
	
	private int seatNumber;
	private Passenger passengerInfo;
	
	Seat(int seatNumber) {
		this.seatNumber = seatNumber;
		this.passengerInfo = null;
	}
	
	public int getSeatNumber() {
		return seatNumber;
	}
	
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public boolean isSeatAvailability() {
		if(passengerInfo == null) {
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
