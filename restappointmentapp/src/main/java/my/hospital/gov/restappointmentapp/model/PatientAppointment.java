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

	//Assign variables to attributes in appointment table
	@Entity
	@Table (name = "appointment")
	public class PatientAppointment {

		//Primary key for appointment table
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "appointmentID")
		private int appointmentID;
		
		@Column(name = "date")
		private Date date;
		
//		@Column(name = "time")
//		private Time time;
		
//		//Foreign key 
//		@ManyToOne
//		@JoinColumn(name = "doctorID")
//		private Doctor doctorID;
		
		@ManyToOne
		@JoinColumn(name = "patientID")
		private PatientDetail patientID;
		
		@ManyToOne
		@JoinColumn(name = "roomSlotID")
		private RoomSlot roomSlotID;
		
//		@ManyToOne
//		@JoinColumn(name = "staffID")
//		private Staff staffID;
		
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
		
//		public Time getTime() {
//			return time;
//		}
//		public void setTime(Time time) {
//			this.time = time;
//		}
		
//		public Doctor getDoctorID() {
//			return doctorID;
//		}
//		public void setDoctorID(Doctor doctorID) {
//			this.doctorID = doctorID;
//		}
		
		public PatientDetail getPatientID() {
			return patientID;
		}
		public void setPatientID(PatientDetail patientID) {
			this.patientID = patientID;
		}
		
		public RoomSlot getRoomSlotID() {
			return roomSlotID;
		}
		public void setRoomSlotID(RoomSlot roomSlotID) {
			this.roomSlotID = roomSlotID;
		}
//		public Staff getStaffID() {
//			return staffID;
//		}
//		public void setStaffID(Staff staffID) {
//			this.staffID = staffID;
//		}
		
		
	}

