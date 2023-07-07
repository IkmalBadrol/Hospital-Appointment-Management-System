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
	private String roomId;
	
	@Column (name = "roomName")
	private String name;
	// name
	
	@OneToOne
	@JoinColumn(name = "doctorID")
	private Doctor doctor;
	
	public String getRoomID() {
		return roomId;
	}
	public void setRoomID(String roomId) {
		this.roomId = roomId;
	}
	
	
	public String getRoomName() {
		return name;
	}
	public void setRoomName(String name) {
		this.name = name;
	}
	
	
	public Doctor getDoctorID() {
		return doctor;
	}
	public void setDoctorID(Doctor doctor) {
		this.doctor = doctor;
	}
	
}
