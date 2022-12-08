
public class Passenger {
	private String passengerName;
	private String address;
	private String phoneNumber;
	private  String idNumber;
	
	Passenger(String passengerName, String address, String phoneNumber, String idNumber) {
		this.passengerName = passengerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.idNumber = idNumber;
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

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	public String toString() {
		return "Name: " + passengerName + " " + "Address: " + address + " " + "Phone Number: " + phoneNumber + "" + "ID Number: " + idNumber;
	}
}
