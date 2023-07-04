package my.hospital.gov.restappointmentapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
/**
 * 
 * @author ikmalbadrol
 * This class contain of the rooms attributes
 *
 */
@Entity
@Table (name = "room")
public class Room {

	@Id
	@Column (name = "roomID")
	private String roomID;
	
	@Column (name = "roomName")
	private String roomName;
	// name
	
	@OneToOne
	@JoinColumn(name = "doctorID")
	private Doctor doctor;
	
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	
	public Doctor getDoctorID() {
		return doctor;
	}
	public void setDoctorID(Doctor doctor) {
		this.doctor = doctor;
	}
	
}
