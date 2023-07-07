package my.hospital.gov.restappointmentapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author norbalqish
 * This class contain of all patients' attributes in the database
 *
 */
@Entity
@Table(name="Patient")
public class PatientDetail {

	// "name" is same as in database patient table

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="patientID")
	private int patientId;
	
	@Column (name="patientName")
	private String name;
	
	@Column (name="patientICNumber")
	private String icNumber;
	
	@Column (name="patientPhoneNumber")
	private String phoneNumber;
	
	@Column (name="patientAge")
	private int age;
	
	@Column (name="patientGender")
	private String  gender;
	
	@Column (name="patientAddress")
	private String address;
	
	
	
	public int getPatientID() {
		return patientId;
	}
	public void setPatientID(int patientID) {
		this.patientId = patientID;
	}
	
	public String getPatientName() {
		return name;
	}
	public void setPatientName(String name) {
		this.name = name;
	}
	
	public String getPatientICNumber() {
		return icNumber;
	}
	public void setPatientICNumber(String icNumber) {
		this.icNumber = icNumber;
	}
	
	public String getPatientPhoneNumber() {
		return phoneNumber;
	}
	public void setPatientPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getPatientAge() {
		return age;
	}
	public void setPatientAge(int age) {
		this.age = age;
	}
	
	public String getPatientGender() {
		return gender;
	}
	public void setPatientGender(String gender) {
		this.gender = gender;
	}
	
	public String getPatientAddress() {
		return address;
	}
	public void setPatientAddress(String address) {
		this.address = address;
	}
	

}

