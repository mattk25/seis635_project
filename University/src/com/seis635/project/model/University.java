package com.seis635.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * Entity implementation class for Entity: University
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="University.getUniversityByName",query="SELECT u FROM University u WHERE u.name = :univname"),
	@NamedQuery(name="University.findAll",query="SELECT u FROM University u")
})
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class University implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int university_id;
	@Column(unique=true,length=225)
	private String name;
	@OneToMany
	@JoinColumn(name="university_id")
	private List<Department> departments;
	
	public University() {}
	public University(String name) {
		this.name = name;
	}
	
	
	public void addDepartment(Department dept) {
		if(departments.contains(dept)) {
			return;
		} else {
			dept.setUniversity(this);
			getDepartments().add(dept);
		}
	}
	
	
	
	
	
	public int getUniversity_id() {
		return university_id;
	}
	
	public void setUniversity_id(int university_id) {
		this.university_id = university_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public List<Department> getDepartments() {
		return departments;
	}


	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	
	
   
}
