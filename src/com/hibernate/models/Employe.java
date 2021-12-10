package com.hibernate.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="Employee")
@NamedQueries(value= {
		@NamedQuery(name="emp.req1",query="from Employe"),
		@NamedQuery(name="emp.req2",query="select e from Employe e inner join e.departement d where d.name=:name"),
		@NamedQuery(name="emp.req3",query="select d.name, count(e) from Employe e right join e.departement d group by d.name"),
		@NamedQuery(name="emp.req4",query="select e.first_name,e.start_date from Employe e inner join e.departement d where d.name='Administration'"),
		@NamedQuery(name="emp.req5",query="delete from Employe e where e.departement in (select d  from Departement d where d.name = 'Loans')"),
		@NamedQuery(name="emp.req6",query="update Employe e set end_date = current_date where e.departement in (select d  from Departement d where d.name = 'Operations')")
})
public class Employe implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="EMP_ID")
	private int id;
	
	@Column
	private String first_name;
	
	@Column
	private String last_name;
	
	@Column
	private LocalDate start_date;
	
	@Column
	private LocalDate end_date;
	
	@Column
	private String title;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="DEPT_ID")
	private Departement departement;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", start_date="
				+ start_date + ", end_date=" + end_date + ", title=" + title + ", departement=" + departement + "]";
	}
}