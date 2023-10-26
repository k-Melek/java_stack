package com.melek.beltexam.models;

import java.time.LocalTime;  // Import LocalTime from java.time
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "yogas")
public class Yoga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "You need a Yoga Class Name!!!!")
    @Size(min = 4, max = 200, message = "Name must be at least 4 characters!")
    private String name;

    @NotBlank(message = "You need a Day!!!!")
    @Size(min = 4, max = 200, message = "Day must be at least 4 characters!")
    private String day;

    @NotNull(message = "Price has to be a positive number")
    @Min(value = 1, message = "Price has to be a positive number")
    @Max(value = 999)
    private Integer price;

    @NotNull
    @DateTimeFormat(pattern="HH:mm")
    private LocalTime time;

    @NotBlank(message = "You need a Description!!!!")
    @Size(min = 4, max = 200, message = "Description must be at least 4 characters!")
    private String description;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    // M:1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User postedBy;
    
    
 // Many To many
 	@ManyToMany(fetch = FetchType.LAZY)
 	@JoinTable(name = "courses_students", 
 				joinColumns = @JoinColumn(name = "yoga_id"), 
 				inverseJoinColumns = @JoinColumn(name = "student_id"))
 	private List<Student> studentsList;

    public User getPostedBy() {
        return postedBy;
    }

    public List<Student> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(List<Student> studentsList) {
		this.studentsList = studentsList;
	}

	public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    // Default constructor
    public Yoga() {
    }

    // Getters and setters for other properties
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
