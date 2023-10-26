package com.melek.teamgame.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="teams")
public class Team {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="you need a Team Name!!!!")
	@Size(min = 4, max = 200, message="Team Name must be at least 4 characteres!")
	private String teamName;
	
	@NotNull(message="Skill Level must be between 1 and 5")
	@Min(value=1)
	@Max(value=5)
	private Integer skillLevel;
	
	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	@NotBlank(message="you need to choose a game day")
	@Size(min = 4, max = 200, message="Game day must be at least 4 characteres!")
	private String gameDay;
	
	
	// M:1
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User leader;
	
	
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    
    

    // EMPTY CONSTRUCTOR
 	public Team() {}
 	
 	//	----- methods ---
     // other getters and setters removed for brevity
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

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(Integer skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getGameDay() {
		return gameDay;
	}

	public void setGameDay(String gameDay) {
		this.gameDay = gameDay;
	}

	
}
