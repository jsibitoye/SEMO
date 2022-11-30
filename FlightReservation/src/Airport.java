
public class Airport {
	private String airportName;
	private String city;
	private String country;

	Airport(String city, String country, String airportName) {
		this.city = city;
		this.country = country;
		this.airportName = airportName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String toString() {
		return airportName + ", " + city + ", " + country;
	}
}
