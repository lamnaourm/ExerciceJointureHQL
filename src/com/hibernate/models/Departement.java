package com.hibernate.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="DEPARTMENT")
@NamedQueries(value= {
		@NamedQuery(name="dept.req1",query="from Departement")
})
public class Departement implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="DEPT_ID")
	private int id;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy="departement", fetch=FetchType.EAGER)
	private List<Employe> employs;
	
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
	@Override
	public String toString() {
		return "Departement [id=" + id + ", name=" + name + "]";
	}	
}
