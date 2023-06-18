package my.hospital.gov.restappointmentapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@Column (name = "doctorID" )
	private String doctorID;	
	@Column (name = "doctorName" )
	private String doctorName;
	@Column (name = " doctorICNumber")
	private String doctorICNumber;
	@Column (name = "doctorPhoneNumber" )
	private String doctorPhoneNum;
	@Column (name = "doctorAge" )
	private int doctorAge;
	@Column (name = "doctorGender")
	private String doctorGender;
	@Column (name = "doctorAddress" )
	private String doctorAddress;
	
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public String getDoctorICNumber() {
		return doctorICNumber;
	}
	public void setDoctorICNumber(String doctorICNumber) {
		this.doctorICNumber = doctorICNumber;
	}
	
	public String getDoctorPhoneNum() {
		return doctorPhoneNum;
	}
	public void setDoctorPhoneNum(String doctorPhoneNum) {
		this.doctorPhoneNum = doctorPhoneNum;
	}
	
	public int getDoctorAge() {
		return doctorAge;
	}
	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	}
	
	public String getDoctorGender() {
		return doctorGender;
	}
	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}
	
	public String getDoctorAddress() {
		return doctorAddress;
	}
	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}
}
