	package my.hospital.gov.restappointmentapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author ikmalbadrol
 * This class contain of doctor's attributes
 *
 */
@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@Column (name = "doctorID" )
	private String doctorId;	
	// doctorId
	
	
	@Column (name = "doctorName" )
	private String name;
	// name
	
	@Column (name = " doctorICNumber")
	private String icNumber;
	// icNumber
	
	
	public String getDoctorID() {
		return doctorId;
	}
	public void setDoctorID(String doctorID) {
		this.doctorId = doctorID;
	}
	
	public String getDoctorName() {
		return name;
	}
	public void setDoctorName(String doctorName) {
		this.name = doctorName;
	}
	
	public String getDoctorICNumber() {
		return icNumber;
	}
	public void setDoctorICNumber(String doctorICNumber) {
		this.icNumber = doctorICNumber;
	}
	
	
}
