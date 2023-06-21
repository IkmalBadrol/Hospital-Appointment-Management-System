package my.hospital.gov.restappointmentapp.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Date;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.hospital.gov.restappointmentapp.model.Doctor;
import my.hospital.gov.restappointmentapp.model.PatientAppointment;
import my.hospital.gov.restappointmentapp.model.PatientDetail;
import my.hospital.gov.restappointmentapp.model.RoomSlot;
import my.hospital.gov.restappointmentapp.model.Room;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;

@Controller
public class MonitoringMenuController
{
	
	
	int appointmentID;
	Date appointmentDate;
	PatientDetail patientID;
    RoomSlot roomSlotID;
	
    private RestTemplate restTemplate = new RestTemplate();
    private String defaultURI = "http://localhost:8080/appointmentapp/api/Monitor";


    // get list of all appointment from both room1, room2, and room3 
	@GetMapping("/appointment/data")
	public String getAppointment(Model model) {
		
		//The URI for GET Doctors
		String uri = "http://localhost:8080/appointmentapp/api/Monitor";
		
		//Get a list doctors from the web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PatientAppointment[]> response = restTemplate.getForEntity(uri, PatientAppointment[].class);
		
		//Parse JSON data to array of object  
		PatientAppointment appointment[] = response.getBody();
		
		//Parse an array to a list object
		List<PatientAppointment> appointmentList = Arrays.asList(appointment);
		
		//Attach list to model as attribute
		model.addAttribute("PatientAppointments", appointmentList);
		
		return "allAppointment";
	}
	
	// get list of appointment from room 1
	@GetMapping("/appointment/room1")
	public String getAppointmentRoom1(Model model) {
		
		//The URI for GET Doctors
		String uri = "http://localhost:8080/appointmentapp/api/Monitor";
		
		//Get a list doctors from the web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PatientAppointment[]> response = restTemplate.getForEntity(uri, PatientAppointment[].class);
		
		//Parse JSON data to array of object  
		PatientAppointment room1[] = response.getBody();
		
		//Parse an array to a list object
		List<PatientAppointment> appointmentRoom1 = Arrays.asList(room1);
		
		//Attach list to model as attribute
		model.addAttribute("AppointmentRoom1", appointmentRoom1);
		
		return "appointmentRoom1";
	}
	
	// get list of appointment from room 2
	@GetMapping("/appointment/room2")
	public String getAppointmentRoom2(Model model) {
		
		//The URI for GET Doctors
		String uri = "http://localhost:8080/appointmentapp/api/Monitor";
		
		//Get a list doctors from the web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PatientAppointment[]> response = restTemplate.getForEntity(uri, PatientAppointment[].class);
		
		//Parse JSON data to array of object  
		PatientAppointment room2[] = response.getBody();
		
		//Parse an array to a list object
		List<PatientAppointment> appointmentRoom2 = Arrays.asList(room2);
		
		//Attach list to model as attribute
		model.addAttribute("AppointmentRoom2", appointmentRoom2);
		
		return "appointmentRoom2";
	}
	
	// get list of appointment from room 3
	@GetMapping("/appointment/room3")
	public String getAppointmentRoom3(Model model) {
		
		//The URI for GET Doctors
		String uri = "http://localhost:8080/appointmentapp/api/Monitor";
		
		//Get a list doctors from the web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PatientAppointment[]> response = restTemplate.getForEntity(uri, PatientAppointment[].class);
		
		//Parse JSON data to array of object  
		PatientAppointment room3[] = response.getBody();
		
		//Parse an array to a list object
		List<PatientAppointment> appointmentRoom3 = Arrays.asList(room3);
		
		//Attach list to model as attribute
		model.addAttribute("AppointmentRoom3", appointmentRoom3);
		
		return "appointmentRoom3";
	}
	
	// @ModelAttribute will bind the incoming request data to patientAppointment
		// @RequestParam  retrieve appointmentID from request parameters
		@GetMapping("/appointment/updateStatusRoom1/{appointmentID}")
		public String getPatientID1 (@PathVariable Integer appointmentID, Model model)
		{
			//Create a new RestTemplate 
			// HTTP request
			String Status="FINISHED";
			String pageTitle = "New Appointment";
			PatientAppointment appointment = new PatientAppointment();
			
			if (appointmentID>0)
			{
				String uri = defaultURI + "/" + appointmentID;
				
				RestTemplate restTemplate = new RestTemplate();
				appointment = restTemplate.getForObject(uri, PatientAppointment.class);
				
				pageTitle = "Update Appointment Status";
			}
			
			model.addAttribute("appointment",appointment);
			model.addAttribute("pageTitle", pageTitle);
			model.addAttribute("Status",Status);
		
			return "appointmentinfoRoom1";
			
		}
		
		@GetMapping("/appointment/updateStatusRoom2/{appointmentID}")
		public String getPatientIDR2 (@PathVariable Integer appointmentID, Model model)
		{
			//Create a new RestTemplate 
			// HTTP request
			String Status="FINISHED";
			String pageTitle = "New Appointment";
			PatientAppointment appointment = new PatientAppointment();
			
			if (appointmentID>0)
			{
				String uri = defaultURI + "/" + appointmentID;
				
				RestTemplate restTemplate = new RestTemplate();
				appointment = restTemplate.getForObject(uri, PatientAppointment.class);
				
				pageTitle = "Update Appointment Status";
			}
			
			model.addAttribute("appointment",appointment);
			model.addAttribute("pageTitle", pageTitle);
			model.addAttribute("Status",Status);
		
			return "appointmentinfoRoom2";
			
		}
		
		@GetMapping("/appointment/updateStatusRoom3/{appointmentID}")
		public String getPatientIDR3 (@PathVariable Integer appointmentID, Model model)
		{
			//Create a new RestTemplate 
			// HTTP request
			String Status="FINISHED";
			String pageTitle = "New Appointment";
			PatientAppointment appointment = new PatientAppointment();
			
			if (appointmentID>0)
			{
				String uri = defaultURI + "/" + appointmentID;
				
				RestTemplate restTemplate = new RestTemplate();
				appointment = restTemplate.getForObject(uri, PatientAppointment.class);
				
				pageTitle = "Update Appointment Status";
			}
			
			model.addAttribute("appointment",appointment);
			model.addAttribute("pageTitle", pageTitle);
			model.addAttribute("Status",Status);
		
			return "appointmentinfoRoom3";
			
		}
		
		@RequestMapping("/appointment/saveStatusRoom1")
		public String updateAppointmentStatus1 (@ModelAttribute PatientAppointment appointment)
		{
			//Create a new RestTemplate
			RestTemplate restTemplate = new RestTemplate();
			
			//Create request body
			HttpEntity<PatientAppointment> request = new HttpEntity<PatientAppointment>(appointment);
			
			String appointmentResponse = "";
			
			if (appointment.getAppointmentID() > 0)
			{
				//This block update a new order type and
				//Send request as PUT
				restTemplate.put(defaultURI, request, PatientAppointment.class);
				
			}else {
				//This block add a new order type
				//Send request as POST
				appointmentResponse = restTemplate.postForObject(defaultURI, request, String.class);
			}
			
			System.out.println(appointmentResponse);
			
			//Redirect request to display a list of order type
			return "redirect:/appointment/room1";
			
		}
	
		@RequestMapping("/appointment/saveStatusRoom2")
		public String updateAppointmentStatus2 (@ModelAttribute PatientAppointment appointment)
		{
			//Create a new RestTemplate
			RestTemplate restTemplate = new RestTemplate();
			
			//Create request body
			HttpEntity<PatientAppointment> request = new HttpEntity<PatientAppointment>(appointment);
			
			String appointmentResponse = "";
			
			if (appointment.getAppointmentID() > 0)
			{
				//This block update a new order type and
				//Send request as PUT
				restTemplate.put(defaultURI, request, PatientAppointment.class);
				
			}else {
				//This block add a new order type
				//Send request as POST
				appointmentResponse = restTemplate.postForObject(defaultURI, request, String.class);
			}
			
			System.out.println(appointmentResponse);
			
			//Redirect request to display a list of order type
			return "redirect:/appointment/room2";
			
		}
	
	
		@RequestMapping("/appointment/saveStatusRoom3")
		public String updateAppointmentStatus3 (@ModelAttribute PatientAppointment appointment)
		{
			//Create a new RestTemplate
			RestTemplate restTemplate = new RestTemplate();
			
			//Create request body
			HttpEntity<PatientAppointment> request = new HttpEntity<PatientAppointment>(appointment);
			
			String appointmentResponse = "";
			
			if (appointment.getAppointmentID() > 0)
			{
				//This block update a new order type and
				//Send request as PUT
				restTemplate.put(defaultURI, request, PatientAppointment.class);
				
			}else {
				//This block add a new order type
				//Send request as POST
				appointmentResponse = restTemplate.postForObject(defaultURI, request, String.class);
			}
			
			System.out.println(appointmentResponse);
			
			//Redirect request to display a list of order type
			return "redirect:/appointment/room3";
			
		}
}
