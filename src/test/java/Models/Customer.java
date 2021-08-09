package Models;

public class Customer {
	private String fullName;

	private String email;

	private String phone;

	private String hearAbout;

	private String referral;

	public Customer(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getHearAbout() {
		return hearAbout;
	}

	public String getReferral() {
		return referral;
	}
}
