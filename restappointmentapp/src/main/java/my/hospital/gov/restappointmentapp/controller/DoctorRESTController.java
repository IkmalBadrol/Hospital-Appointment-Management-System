package my.hospital.gov.restappointmentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.hospital.gov.restappointmentapp.model.Doctor;
import my.hospital.gov.restappointmentapp.repository.DoctorRepository;

@RestController
@RequestMapping("/api/doctors")
public class DoctorRESTController {
	
	@Autowired
	private DoctorRepository doctorRepository;

//	public ResponseEntity<HttpStatus> deleteDoctor(long doctorID) {
//		
//	}
//	
	@GetMapping
	public List<Doctor> getDoctors(){
		return doctorRepository.findAll();
	}
	
	
//	// Find doctor's name in database
//	@GetMapping
//	public List<Doctor> findDoctorByName(@PathVariable String doctorName){
//		return doctorRepository.findDoctorByName(doctorName);
//	}
	
//	public Doctor getDoctor(long doctorID) {
//		
//	}
//	
//	public Doctor insertDoctor(Doctor doctor) {
//		
//	}
//	
//	public Doctor updateDoctor(Doctor doctor) {
//		
//	}
}
