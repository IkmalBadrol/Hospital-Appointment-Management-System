package my.hospital.gov.restappointmentapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Patient")
public class PatientDetail {



 //same as in database patient table

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="patientID")
	private int patientID;
	
	@Column (name="patientName")
	private String patientName;
	
	@Column (name="patientICNumber")
	private String patientICNumber;
	
	@Column (name="patientPhoneNumber")
	private String patientPhoneNumber;
	
	@Column (name="patientAge")
	private int patientAge;
	
	@Column (name="patientGender")
	private String  patientGender;
	
	@Column (name="patientAddress")
	private String patientAddress;
	
	
	
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientICNumber() {
		return patientICNumber;
	}
	public void setPatientICNumber(String patientICNumber) {
		this.patientICNumber = patientICNumber;
	}
	public String getPatientPhoneNumber() {
		return patientPhoneNumber;
	}
	public void setPatientPhoneNumber(String patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	

}

