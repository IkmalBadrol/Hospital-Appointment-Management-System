package my.hospital.gov.restappointmentapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import my.hospital.gov.restappointmentapp.model.Doctor;

/**
 * 
 * @author ikmalbadrol
 * 
 * This class is to get the list of all doctors 
 *
 */
@Controller
public class DoctorMenuController {

	/**
	 * This method ....
	 * @return
	 */
	@GetMapping("/doctor/list")
	public ResponseEntity<String> getDoctors(){
		
		//The URI for GET Doctors data
		String uri = "http://localhost:8080/appointmentapp/api/doctors";
		
		//Get a list Doctors from the web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Doctor[]> response = restTemplate.getForEntity(uri, Doctor[].class);
		
		//Parse JSON data to array of object
		Doctor doctors[] = response.getBody();
	
		//Generate message
		System.out.println(this.getClass().getSimpleName());
		System.out.println("Doctors Details " + doctors.length + "\n");
		
		//Display Doctors' information - for debugging
		for(Doctor doctor:doctors) {
			
			System.out.println(doctor.getDoctorID());
			System.out.println(doctor.getDoctorName());
			System.out.println(doctor.getDoctorICNumber());
		}
		
		//For Postman status
		String message = "Check message in console for Doctor's information";
		
		//Display message in web
		//ResponseEntity for message in http
		return new ResponseEntity<>(message, HttpStatus.OK);		
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	// Get doctors list
	@GetMapping("/doctor/list-view")
	public String getDoctors(Model model) {
		
		//The URI for GET Doctors
		String uri = "http://localhost:8080/appointmentapp/api/doctors";
		
		//Get a list doctors from the web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Doctor[]> response = restTemplate.getForEntity(uri, Doctor[].class);
		
		//Parse JSON data to array of object  
		Doctor doctors[] = response.getBody();
		
		//Parse an array to a list object
		List<Doctor> doctorList = Arrays.asList(doctors);
		
		//Attach doctorList to model as attribute
		model.addAttribute("Doctors", doctorList);
		
		// return html for doctor list
		return "doctor";
	}
}
