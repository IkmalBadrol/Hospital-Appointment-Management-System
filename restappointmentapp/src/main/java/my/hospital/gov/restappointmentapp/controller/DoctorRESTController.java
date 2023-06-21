package my.hospital.gov.restappointmentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.hospital.gov.restappointmentapp.model.Doctor;
import my.hospital.gov.restappointmentapp.repository.DoctorRepository;

@RestController
@RequestMapping("/api/doctors")
public class DoctorRESTController {
	
	/**
	 * Autowired instance of DoctorRepository for accessing doctor-related data.
	 */

	@Autowired
	private DoctorRepository doctorRepository;


	/**
	 * Retrieves a list of all doctors.
	 *
	 * @return List of Doctor objects representing the doctors in the system.
	 */
	@GetMapping
	public List<Doctor> getDoctors()
	{
		return doctorRepository.findAll();
	}
	
	
	
	

}
