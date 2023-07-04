package my.hospital.gov.restappointmentapp.model;

	import java.sql.Date;
	import java.sql.Time;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.Table;
import my.hospital.gov.restappointmentapp.repository.DoctorRepository;
/**
 * This class represents an patient's appointment
 * 
 * @author ikmalbadrol
 * 
 *
 */
	//Assign variables to attributes in appointment table
	@Entity
	@Table (name = "appointment")
	public class PatientAppointment {

		//Primary key for appointment table
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "appointmentID")
		private int appointmentID;
		// appointmentId
		
		@Column(name = "date")
		private Date date;
	
		@ManyToOne
		@JoinColumn(name = "patientID")
		private PatientDetail patientID;
		
		@ManyToOne
		@JoinColumn(name = "roomSlotID")
		private RoomSlot roomSlotID;
		
		@Column(name="treatmentStatus")
		private String treatmentStatus;
		
		
		public String getTreatmentStatus() {
			return treatmentStatus;
		}
		public void setTreatmentStatus(String treatmentStatus) {
			this.treatmentStatus = treatmentStatus;
		}
		public int getAppointmentID() {
			return appointmentID;
		}
		public void setAppointmentID(int appointmentID) {
			this.appointmentID = appointmentID;
		}
		
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		
		public PatientDetail getPatientID() {
			return patientID;
		}
		public void setPatientID(PatientDetail patientID) {
			this.patientID = patientID;
		}
		
		public RoomSlot getRoomSlotID()
        {
			return roomSlotID;
		}
		public void setRoomSlotID(RoomSlot roomSlotID) {
			this.roomSlotID = roomSlotID;
		}
		
		
	}

