package com.melek.projectmanager.models;

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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "projects")
public class Project {

	// MEMBER VARIABLES
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotNull
		@Size(min = 5, max = 200, message = "you need a title !!")
		private String title;
		
		@NotNull
		@Size(min = 5, max = 200, message = "you need to write a description !!")
		private String description;
		
		@NotNull(message = "you need to fill a due date!")
		@Future(message ="Due date must be in the future!")
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date dueDate;
		
		// M:1
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "projectLead_id")
		private User lead;
		
		// Many To many
		@ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    		name = "users_projects",
	    		joinColumns = @JoinColumn(name="project_id"),
	    		inverseJoinColumns = @JoinColumn(name="user_id")
	    		)
	    private List<User> users;
		
		
		

		// This will not allow the createdAt column to be updated after creation
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
		
		// Constructor
		public Project() {}

		// Getters and setters
		
		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}
		
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getDueDate() {
			return dueDate;
		}

		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}

		public User getLead() {
			return lead;
		}

		public void setLead(User lead) {
			this.lead = lead;
		}

		
		
		
}
