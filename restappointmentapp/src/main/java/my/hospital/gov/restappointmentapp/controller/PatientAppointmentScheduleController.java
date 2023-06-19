package my.hospital.gov.restappointmentapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;

import my.hospital.gov.restappointmentapp.model.Doctor;
import my.hospital.gov.restappointmentapp.model.PatientAppointment;
import my.hospital.gov.restappointmentapp.model.PatientDetail;
import my.hospital.gov.restappointmentapp.model.RoomSlot;
import my.hospital.gov.restappointmentapp.model.Room;
import my.hospital.gov.restappointmentapp.repository.DoctorRepository;

@Controller
public class PatientAppointmentScheduleController {
	
	private PatientAppointment patientAppointment;
	private PatientDetail patientDetail;
	@Autowired
	private DoctorRepository doctorRepository;
	
	private String defaultURI = "http://localhost:8080/appointmentapp/api/appointments";

	//
	@GetMapping("/appointments/schedule")
	public String getPatientAppointments(Model model) {
		String uri = "http://localhost:8080/appointmentapp/api/appointments";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PatientAppointment[]> responseEntity = restTemplate.getForEntity(uri, PatientAppointment[].class);
		
		PatientAppointment patientAppointments[] = responseEntity.getBody();
		
		List<PatientAppointment>patientAppointmentList = Arrays.asList(patientAppointments);
		
		model.addAttribute("patientAppointments", patientAppointmentList);
		
		return "appointment";
	}
	
	
	// @ModelAttribute will bind the incoming request data to patientAppointment
	// @RequestParam  retrieve appointmentID from request parameters
	@RequestMapping("/appointments/save")
	public String updatePatientAppointment (@ModelAttribute PatientAppointment patientAppointment)
	{
		//Create a new RestTemplate 
		// HTTP request
		RestTemplate restTemplateAppointment = new RestTemplate();
		
		//Create request body
		HttpEntity<PatientAppointment> request = new HttpEntity<PatientAppointment>(patientAppointment);
		
		// Initialize empty String
		String patientAppointmentResponse = "";
		
		
		// Check if appointment id existed
		if(patientAppointment.getAppointmentID()> 0)
		{
			// This block update a new order type and
			// Send request as PUT
			// Send request and update appointment
			// Updated appointment return as PatienAppointment object
			restTemplateAppointment.put(defaultURI, request, PatientAppointment.class);
			
		}else {
			//This block add a new order type
			//Send request as POST
			patientAppointmentResponse = restTemplateAppointment.postForObject(defaultURI, request, String.class);
		}
		
		System.out.println(patientAppointmentResponse);
		
		//Redirect request to display a list of order type
		return "redirect:/appointments/appointmentList";
		
	}
	
//	@GetMapping
//	public String getPatientName(@ModelAttribute PatientDetail patientDetail, @RequestParam long patientName) {
//		
//		if(patientDetail.equals(patientName)) {
//			String uri = defaultURI + "/" +patientName;
//			
//			RestTemplate restTemplate = new RestTemplate();
//			patientDetail = restTemplate.getForObject(uri, PatientDetail.class);
//			
//		}
//	
//		model.addAtt
//	}
	


	// Validate patient IC Number
	@GetMapping("/appointments/{patientIC}")
	public String getAppointment(@PathVariable Integer patientIC,  Model model, 
			@RequestParam(name = "patientIC1", required =false) String patientIC1) {
		
		String pageTitle="Appointment";
		
		PatientAppointment patientAppointment = new PatientAppointment();
		
		PatientDetail currentPatientDetail = new PatientDetail();
			
		if(!Strings.isBlank(patientIC1)) {
			//String uri = defaultURI + "/" +patientIC;
			
			RestTemplate restPatient = new RestTemplate();
			currentPatientDetail = restPatient.getForObject("http://localhost:8080/appointmentapp/api/patientdetails/patientIC/" + patientIC1, PatientDetail.class);	
			patientAppointment.setPatientID(currentPatientDetail);			
		}
		
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<PatientAppointment[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/appointmentapp/api/appointments", PatientAppointment[].class);
//		
//		PatientAppointment patientAppointments[] = responseEntity.getBody();
//		
//		List<PatientAppointment> AppointmentList = Arrays.asList(patientAppointments);
		
	
		RestTemplate restTemplateRoomSlot = new RestTemplate();
		ResponseEntity<RoomSlot[]> responseRoomSlot = restTemplateRoomSlot.getForEntity("http://localhost:8080/appointmentapp/api/roomslots", RoomSlot[].class);
		
		RoomSlot roomSlotArray[] = responseRoomSlot.getBody();
		
		List<RoomSlot>slotList = Arrays.asList(roomSlotArray);
		
		for( RoomSlot roomslot : slotList) {
			
			System.out.println("test data" + roomslot.getRoomID().getDoctorID());
		}
			
		
//		RestTemplate restTemplateDoctor = new RestTemplate();
//		ResponseEntity<Doctor[]> responseDoctor = restTemplateDoctor.getForEntity("http://localhost:8080/appointmentapp/api/doctors", Doctor[].class);
//		
//		Doctor doctorArray[] = responseDoctor.getBody();
//		
//		List<Doctor>doctorList = Arrays.asList(doctorArray);
		
		
	    
		model.addAttribute("patientAppointment", patientAppointment);
		model.addAttribute("Appointment",pageTitle);
		model.addAttribute("patientID", currentPatientDetail);
		model.addAttribute("slotList", slotList);
		//model.addAttribute("AppointmentList", AppointmentList);
		//model.addAttribute("roomList", roomList);
		//model.addAttribute("doctorList", doctorList);
		
		return "appointment";
	}
	
	
	@GetMapping("/appointments/appointmentList")
	public String getAppointmentsList(Model model) {
		
		//The URI for GET Doctors
		String uri = "http://localhost:8080/appointmentapp/api/appointments";
		
		//Get a list doctors from the web services
		RestTemplate restTemplateAppointmentsList = new RestTemplate();
		ResponseEntity<PatientAppointment[]> response = restTemplateAppointmentsList.getForEntity(uri, PatientAppointment[].class);
		
		//Parse JSON data to array of object  
		PatientAppointment appointmentList[] = response.getBody();
		
		//Parse an array to a list object
		List<PatientAppointment> apptList = Arrays.asList(appointmentList);
		
		//Attach list to model as attribute
		model.addAttribute("apptList", apptList);
		
		return "appointmentlist";
	}

	
	@GetMapping("/appointments/doctor")
	public String getDoctorAppointment(Model model) {
		//String uri = "http://localhost:8080/appointmentapp/api/appointments";
		
		//PatientAppointment patientAppointment = new PatientAppointment();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PatientAppointment[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/appointmentapp/api/appointments", PatientAppointment[].class);
		
		PatientAppointment patientAppointments[] = responseEntity.getBody();
		
		List<PatientAppointment> AppointmentList = Arrays.asList(patientAppointments);
		
		for( PatientAppointment appointment : AppointmentList) {
			
			System.out.println("test data" + appointment.getRoomSlotID().getRoomID().getDoctorID().getDoctorName());
		}
	
		
		
		RestTemplate restTemplateRoomSlot = new RestTemplate();
		ResponseEntity<RoomSlot[]> responseRoomSlot = restTemplateRoomSlot.getForEntity("http://localhost:8080/appointmentapp/api/roomslots", RoomSlot[].class);
		
		RoomSlot roomSlotArray[] = responseRoomSlot.getBody();
		
		List<RoomSlot>slotList = Arrays.asList(roomSlotArray);
		
		
		
		RestTemplate restTemplateRoom = new RestTemplate();
		ResponseEntity<Room[]> responseRoom = restTemplateRoom.getForEntity("http://localhost:8080/appointmentapp/api/rooms", Room[].class);
		
		Room roomArray[] = responseRoom.getBody();
		
		List<Room>roomList = Arrays.asList(roomArray);
		
for( PatientAppointment appointment : AppointmentList) {
			
			System.out.println("test data" + appointment.getRoomSlotID().getRoomID().getDoctorID().getDoctorName());
		}

		
		
		
		RestTemplate restTemplateDoctor = new RestTemplate();
		ResponseEntity<Doctor[]> responseDoctor = restTemplateDoctor.getForEntity("http://localhost:8080/appointmentapp/api/doctors", Doctor[].class);
		
		Doctor doctorArray[] = responseDoctor.getBody();
		
		List<Doctor>doctorList = Arrays.asList(doctorArray);
		
		//System.out.println(responseEntity.getAppointmentID());
		
		model.addAttribute("AppointmentList", AppointmentList);
		model.addAttribute("slotList", slotList);
		model.addAttribute("roomList", roomList);
		model.addAttribute("doctorList", doctorList);
				
		return "appointment";
	}
	
}
