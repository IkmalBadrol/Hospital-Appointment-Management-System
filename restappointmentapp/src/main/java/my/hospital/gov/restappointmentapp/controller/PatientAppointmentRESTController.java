package my.hospital.gov.restappointmentapp.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.hospital.gov.restappointmentapp.model.Doctor;
import my.hospital.gov.restappointmentapp.model.PatientAppointment;
//import my.hospital.gov.restappointmentapp.model.RoomSlot;
import my.hospital.gov.restappointmentapp.repository.DoctorRepository;
import my.hospital.gov.restappointmentapp.repository.PatientAppointmentRepository;

@RestController
@RequestMapping("/api/appointments")
public class PatientAppointmentRESTController {

	@Autowired
	private PatientAppointmentRepository patientAppointmentRepository;
	@Autowired
	private DoctorRepository doctorRepository;
//	@Autowired
//	private RoomSlot roomSlot;
	
	@GetMapping
	public List<PatientAppointment> getPatientAppointments(){
		return patientAppointmentRepository.findAll();
	}
	
//	@GetMapping("/{appointmentID}")
//	public PatientAppointment getPatientAppointment(@PathVariable long appointmentID) {
//		
//		PatientAppointment patientAppointment = patientAppointmentRepository.findById(appointmentID).get();
//		return patientAppointment;
//	}
	
	

	@PostMapping
	public PatientAppointment addPatientAppointment(@RequestBody PatientAppointment patientAppointment) {
		return patientAppointmentRepository.save(patientAppointment);
	}
	
	
	@PutMapping
	public PatientAppointment updatePatientAppointment(@RequestBody PatientAppointment patientAppointment) {
	    return patientAppointmentRepository.save(patientAppointment);
	}
	

//	@DeleteMapping("{appointmentID}")
//	public void deletePatientAppointment(@RequestBody PatientAppointment patientAppointment) {
//	    patientAppointmentRepository.delete(patientAppointment);
//	}
	
//	@DeleteMapping("{appointmentID}")
//	public ResponseEntity<HttpStatus> deletePatientAppointment(@PathVariable long appointmentID){
//		
//		patientAppointmentRepository.deleteById(appointmentID);
//		
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
}
