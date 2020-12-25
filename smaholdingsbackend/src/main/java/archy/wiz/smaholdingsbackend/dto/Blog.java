package archy.wiz.smaholdingsbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Blog {

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBlogdate() {
		return blogdate;
	}
	public void setBlogdate(String blogdate) {
		this.blogdate = blogdate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getBlogCategoryId() {
		return blogCategoryId;
	}
	public void setBlogCategoryId(int blogCategoryId) {
		this.blogCategoryId = blogCategoryId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public Blog() {
		this.code = "ARC" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	
	
	
	@Override
	public String toString() {
		return "Blog [id=" + id + ", name=" + name + ", description=" + description + ", blogdate=" + blogdate
				+ ", code=" + code + ", active=" + active + ", blogCategoryId=" + blogCategoryId + ", adminId="
				+ adminId + "]";
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@Column(name="date")
	private String blogdate;
	private String code;
	@Column(name="is_active")
	@JsonIgnore
	private boolean active = true;
	@Column(name="blogcategory_id")
	@JsonIgnore
	private int blogCategoryId;
	@Column(name="admin_id")
	@JsonIgnore
	private int adminId;
}
