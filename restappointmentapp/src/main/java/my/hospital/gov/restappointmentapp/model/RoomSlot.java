package my.hospital.gov.restappointmentapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * 
 * @author ikmalbadrol
 * This class contain of the room slot's attributes
 *
 */
@Entity
@Table (name = "roomslot")
public class RoomSlot {

	@Id
	@Column(name = "roomSlotID")
	private String roomSlotId;
	
	@Column(name = "timeStart")
	private float timeStart;
	
	@Column(name = "timeEnd")
	private float timeEnd;
	
	@ManyToOne
	@JoinColumn (name = "roomID")
	private Room room;
	
	
	public String getRoomSlotID() {
		return roomSlotId;
	}
	
	public void setRoomSlotID(String roomSlotId) {
		this.roomSlotId = roomSlotId;
	}
	
	
	public float getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(float timeStart) {
		this.timeStart = timeStart;
	}
	
	
	public float getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(float timeEnd) {
		this.timeEnd = timeEnd;
	}
	
	
	public Room getRoomID() {
		return room;
	}
	public void setRoomID(Room room) {
		this.room = room;
	}
}
