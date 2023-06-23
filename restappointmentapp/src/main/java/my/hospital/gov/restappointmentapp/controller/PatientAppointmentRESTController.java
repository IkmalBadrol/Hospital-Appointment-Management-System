package my.hospital.gov.restappointmentapp.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

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
	
	@GetMapping
	public List<PatientAppointment> getPatientAppointments(){
		return patientAppointmentRepository.findAll();
	}
	

//	@GetMapping("/{appointmentID}")
//	public Optional<PatientAppointment> getPatientAppointment(@PathVariable long appointmentID) {
//		
//		return patientAppointmentRepository.findById(appointmentID);
//	}
	
	
	// This annotation maps HTTP POST requests to this method.
	@PostMapping
	public PatientAppointment addPatientAppointment(@RequestBody PatientAppointment patientAppointment) {
		return patientAppointmentRepository.save(patientAppointment);
	}	
	
	@PutMapping
	public PatientAppointment updatePatientAppointment(@RequestBody PatientAppointment patientAppointment) {
	    return patientAppointmentRepository.save(patientAppointment);
	}
	

	@PutMapping("/Status")
	public PatientAppointment updateAppointmentStatus(@RequestBody PatientAppointment patientAppointment) {
	    return patientAppointmentRepository.save(patientAppointment);
	}
	

}
