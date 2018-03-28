package model;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean accountActive;
	private boolean hasPremium;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAccountActive() {
		return accountActive;
	}

	public void setAccountActive(boolean accountActive) {
		this.accountActive = accountActive;
	}

	public boolean hasPremium() {
		return hasPremium;
	}

	public void setHasPremium(boolean hasPremium) {
		this.hasPremium = hasPremium;
	}
}
