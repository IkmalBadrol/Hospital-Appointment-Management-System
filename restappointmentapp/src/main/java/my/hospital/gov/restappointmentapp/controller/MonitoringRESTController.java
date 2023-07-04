package my.hospital.gov.restappointmentapp.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.hospital.gov.restappointmentapp.model.PatientAppointment;
import my.hospital.gov.restappointmentapp.repository.PatientAppointmentRepository;

/**
 * 
 * @author idrismahmor
 * This class is the REST Controller of monitoring patient schedule
 *
 */

@RestController
@RequestMapping("/api/Monitor")
public class MonitoringRESTController {

	// bind with the PatientAppointmentRepository
	@Autowired
	private PatientAppointmentRepository appointment;
	
	// get the data of appointment from patient's appointment
	@GetMapping
	public List<PatientAppointment> getPatientAppointments(){
		return appointment.findAll();
	}
	
	// get the data of patient's appointment by ID
	@GetMapping("{appointmentID}")
	public PatientAppointment getAppointment(@PathVariable long appointmentID){
		PatientAppointment appointments = appointment.findById(appointmentID).get(); 
		return appointments;
	}
	
	// update the appointment record
	@PutMapping
	public PatientAppointment updateStatus(@RequestBody PatientAppointment appointments)
	{
		return appointment.save(appointments);
	}
}
