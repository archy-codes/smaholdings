package archy.wiz.smaholdingsbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", code=" + code + ", projectName=" + projectName + ", client=" + client
				+ ", description=" + description + ", value=" + value + ", contactDetails=" + contactDetails
				+ ", status=" + status + ", active=" + active + ", categoryId=" + categoryId + ", adminId=" + adminId
				+ "]";
	}
	//the default constructor
	public Project() {
		this.code = "PRJ" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	
	
	
	/*
	 * private fields
	 */
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  private String code;
	  @Column(name="project_name")
	  @NotBlank(message="please enter the project name!")
	  private String projectName;
	  @NotBlank(message="please enter the client name!")
	  private String client;
	  @Column(name="project_description")
	  @NotBlank(message="please enter the project description!")
	  private String description;
	  @Min(value=1000, message="the project value cannot be less than R1000")
	  private double value;
	  @Column(name="contact_details")
	  @NotBlank(message="please enter the contact details name!")
	  private String contactDetails;
	  @NotBlank(message="please enter the project status name!")
	  private String status;
	  @Column(name="is_active")
	  private boolean active;
	  @Column(name="category_id")
	  @JsonIgnore
	  private int categoryId;
	  @Column(name="admin_id")
	  @JsonIgnore
	  private int adminId;
	
	  @Transient
	  private MultipartFile file;
	  
	  
	  
}
