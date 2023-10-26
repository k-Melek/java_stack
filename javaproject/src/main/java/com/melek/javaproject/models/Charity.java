package com.melek.javaproject.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "charities")
public class Charity {

	// Member variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Name is required!")
	private String name;
	@NotEmpty(message = "rib is required!")
	private String rib;
	@NotEmpty(message = "phone is required!")
	private String phone;
	@NotEmpty(message = "description is required!")
	private String description;
	@NotEmpty(message = "logo is required!")
	private String logo;
	@NotEmpty(message = "foundationYear is required!")
	private int foundationYear;
	@NotEmpty(message = "numJort is required!")
	private String numJort;

	@Enumerated(EnumType.STRING)
	private CharityStatus status;

	// This will not allow the createdAt column to be updated after creation
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// 1:1 Owner Relation Charity ------------------------
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "founder_id")
	private User founder;

	// 1:1 Address Relation Charity ------------------------
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	// M:M Charity to Address
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "charities_categories", joinColumns = @JoinColumn(name = "charity_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;

	// Empty constructor
	public Charity() {
	}

	// Getters and setters

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getFoundationYear() {
		return foundationYear;
	}

	public void setFoundationYear(int foundationYear) {
		this.foundationYear = foundationYear;
	}

	public String getNumJort() {
		return numJort;
	}

	public void setNumJort(String numJort) {
		this.numJort = numJort;
	}

	public CharityStatus getStatus() {
		return status;
	}

	public void setStatus(CharityStatus status) {
		this.status = status;
	}

	public User getFounder() {
		return founder;
	}

	public void setFounder(User founder) {
		this.founder = founder;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
