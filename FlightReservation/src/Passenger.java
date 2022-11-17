
public class Passenger {
	private Name passengerName;
	private String address;
	private String phoneNumber;
	
	Passenger(Name passengerName, String address, String phoneNumber) {
		
	}

	public Name getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(Name passengerName) {
		this.passengerName = passengerName;
	}
	
	public void newPassenger() {
		
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
		return "Name: " + passengerName + "\n" + "Address: " + address + "\n" + "Phone Number: " + phoneNumber;
	}
}
