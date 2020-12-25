package archy.wiz.smaholdingsbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Services {
	
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	public Services() {
		this.icon = "Icon" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	
	@Override
	public String toString() {
		return "Services [id=" + id + ", name=" + name + ", description=" + description + ", icon=" + icon + ", active="
				+ active + "]";
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String icon;
	@Column(name="is_active")
	private boolean active = true;
	
}
