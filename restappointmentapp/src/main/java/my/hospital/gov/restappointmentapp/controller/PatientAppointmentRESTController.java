package my.hospital.gov.restappointmentapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.hospital.gov.restappointmentapp.model.PatientAppointment;
import my.hospital.gov.restappointmentapp.repository.PatientAppointmentRepository;

/**
 * 
 * @author ikmalbadrol
 *This class is the REST controller class fpr patient appointment
 */
@RestController
@RequestMapping("/api/appointments")
public class PatientAppointmentRESTController {

	@Autowired
	private PatientAppointmentRepository patientAppointmentRepository;
	
	
	// Get the list of patients' appointments
	@GetMapping
	public List<PatientAppointment> getPatientAppointments() {
		return patientAppointmentRepository.findAll();
	}
	
	// Patient appointment reschedule
	// Get specific patient's appointment by appointmentID
	@GetMapping("/{appointmentId}")
	public PatientAppointment getPatientAppointment(@PathVariable long appointmentId) {
		
		PatientAppointment patientAppointment= 
				patientAppointmentRepository.findById(appointmentId).get();
		return patientAppointment;
	}	
	
	
	// Saved patient's appointment into database
	@PostMapping
	public PatientAppointment addPatientAppointment(
			@RequestBody PatientAppointment patientAppointment) {
		return patientAppointmentRepository.save(patientAppointment);
	}	
	
	// Saved patient's appointment into database
	@PutMapping
	public PatientAppointment updatePatientAppointment(
			@RequestBody PatientAppointment patientAppointment) {
	    return patientAppointmentRepository.save(patientAppointment);
	}
	

	@PutMapping("/Status")
	public PatientAppointment updateAppointmentStatus(
			@RequestBody PatientAppointment patientAppointment) {
	    return patientAppointmentRepository.save(patientAppointment);
	}
	

}
