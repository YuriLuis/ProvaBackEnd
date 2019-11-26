package com.provabackend.provabackend.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_area")
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String nameArea;

	@Positive
	@NotNull
	private Double maximumBudget;

	@Positive
	@NotNull
	private Double minimumBudget;

	@JsonIgnore
	@OneToMany(mappedBy = "area")
	private List<Project> projects = new ArrayList<Project>();

	public Area() {

	}

	public Area(Integer id, String nameArea, Double maximumBudget, Double minimumBudget, List<Project> projects) {
		super();
		this.id = id;
		this.nameArea = nameArea;
		this.maximumBudget = maximumBudget;
		this.minimumBudget = minimumBudget;
		this.projects = projects;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameArea() {
		return nameArea;
	}

	public void setNameArea(String nameArea) {
		this.nameArea = nameArea;
	}

	public Double getMaximumBudget() {
		return maximumBudget;
	}

	public void setMaximumBudget(Double maximumBudget) {
		this.maximumBudget = maximumBudget;
	}

	public Double getMinimumBudget() {
		return minimumBudget;
	}

	public void setMinimumBudget(Double minimumBudget) {
		this.minimumBudget = minimumBudget;
	}

	public List<Project> getProjects() {
		return projects;
	}
	
	

}
