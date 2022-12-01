
public class Passenger {
	private String passengerName;
	private String address;
	private String phoneNumber;
	
	Passenger(String passengerName, String address, String phoneNumber) {
		this.passengerName = passengerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getPassengerName() { 
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String toString() {
		return "Name: " + passengerName + " " + "Address: " + address + " " + "Phone Number: " + phoneNumber;
	}
}
