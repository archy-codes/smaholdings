package archy.wiz.smaholdingsbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
public class Contactform {

	
	/*getters and setters*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	@Override
	public String toString() {
		return "Contactform [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", active="
				+ active + ", description=" + description + ", categoryId=" + categoryId + "]";
	}
	
	/*private fields*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Pattern(regexp="^[a-zA-Z]", message=" first name should only contain characters!")
	@Range(min=2 , max=20, message="name should not be less than two characters!")
	@Column(name="firstname")
	private String fname;
	@Pattern(regexp="^[a-zA-Z]", message=" last name should only contain characters!")
	@Range(min=2 , max=15, message="last name should not be less than two characters!")
	@Column(name="lastname")
	private String lname;
	@Email(message = "please enter a valid email address!")
	@NotBlank(message = "please enter your email address")
	private String email;
	@Column(name="is_active")
	private boolean active = true;
	@NotBlank(message = "please enter the description!")
	@Pattern(regexp="^[a-zA-Z]", message="description should only contain characters!")
	@Range(min=10 , max=20, message="description should not be less than 20 words!")
	private String description;
	@Column(name="category_id")
	private int categoryId;
}
