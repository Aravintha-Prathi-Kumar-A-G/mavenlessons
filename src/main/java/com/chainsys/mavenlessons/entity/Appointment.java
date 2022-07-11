package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name="Appointments")
public class Appointment {
	@Id
	@Column (name="app_id")
	private int id;
	@Column (name="app_date")
	private Date date;
//	@Column (name="doc_id")
//	private int docId;
	@Column (name="patient_name")
	private String name;
	@Column (name="fees_collected")
	private float fees;
	@Column (name="fees_category")
	private String fees_category;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id", nullable= false, insertable=false, updatable=false)
    private Doctor doctor;

    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setDoctor(Doctor doc) {
        this.doctor = doc;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getApp_date() {
		return date;
	}
	public void setApp_date(Date app_date) {
		this.date = app_date;
	}
//	public int getDoc_id() {
//		return docId;
//	}
//	public void setDoc_id(int doc_id) {
//		this.docId = doc_id;
//	}
	public String getPatient_name() {
		return name;
	}
	public void setPatient_name(String patient_name) {
		this.name = patient_name;
	}
	public float getFees_collected() {
		return fees;
	}
	public void setFees_collected(float fees_collected) {
		this.fees = fees_collected;
	}
	public String getFees_category() {
		return fees_category;
	}
	public void setFees_category(String fees_category) {
		this.fees_category = fees_category;
	}
	@Override
    public String toString() {
        return String.format("%d, %s, %s, %.2f, %s", id, date, name, fees, fees_category);
    }
}
