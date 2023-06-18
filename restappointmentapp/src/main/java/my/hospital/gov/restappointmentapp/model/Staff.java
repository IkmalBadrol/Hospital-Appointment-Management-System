package my.hospital.gov.restappointmentapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="staff")
public class Staff {

	@Id
	@Column(name="staffID")
	private String staffID;
	
	@Column(name="staffName")
	private String staffName;
	
	@Column(name="staffICNumber")
	private String staffICNumber;
	
	@Column(name="staffPhoneNumber")
	private String staffPhoneNumber;
	
	@Column(name="staffAge")
	private int staffAge;
	
	@Column(name="staffGender")
	private String staffGender;
	
	@Column(name="staffAddress")
	private String staffAddress;
	
	@Column(name="staffPassword")
	private String staffPassword;
	
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffICNumber() {
		return staffICNumber;
	}
	public void setStaffICNumber(String staffICNumber) {
		this.staffICNumber = staffICNumber;
	}
	public String getStaffPhoneNumber() {
		return staffPhoneNumber;
	}
	public void setStaffPhoneNumber(String staffPhoneNumber) {
		this.staffPhoneNumber = staffPhoneNumber;
	}
	public int getStaffAge() {
		return staffAge;
	}
	public void setStaffAge(int staffAge) {
		this.staffAge = staffAge;
	}
	public String getStaffGender() {
		return staffGender;
	}
	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	public String getStaffPassword() {
		return staffPassword;
	}
	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}
}
