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

import my.hospital.gov.restappointmentapp.model.Doctor;
import my.hospital.gov.restappointmentapp.model.PatientAppointment;
import my.hospital.gov.restappointmentapp.repository.PatientAppointmentRepository;


@RestController
@RequestMapping("/api/Monitor")
public class MonitoringRESTController {

	@Autowired
	private PatientAppointmentRepository appointment;
	
	//@GetMapping
	//public ResponseEntity<List<PatientAppointment>> getDataFromTables() {
	    // Your code to retrieve data from tables
	//	List<PatientAppointment> dataList = appointment.findAll();
	
	//	return ResponseEntity.ok(dataList);
	//}
	
	@GetMapping
	public List<PatientAppointment> getAppointment(){
		return appointment.findAll();
	}
	
}
