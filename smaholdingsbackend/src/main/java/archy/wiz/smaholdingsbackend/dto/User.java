package archy.wiz.smaholdingsbackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", contactnumber=" + contactnumber + ", role=" + role + ", password=" + password + ", enabled="
				+ enabled + "]";
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String contactnumber;
	private String role;
	private String password;
	private boolean enabled = true;
}
