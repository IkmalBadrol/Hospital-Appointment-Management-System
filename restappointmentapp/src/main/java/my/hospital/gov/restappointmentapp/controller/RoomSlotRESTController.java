package my.hospital.gov.restappointmentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.hospital.gov.restappointmentapp.model.PatientDetail;
import my.hospital.gov.restappointmentapp.model.RoomSlot;
import my.hospital.gov.restappointmentapp.repository.RoomSlotRepository;

/**
 * 
 * @author ikmalbadrol
 * This class is the REST Controller class for Room Slot
 * This class does the web method for view room slot, find available date
 *
 */
@RestController
@RequestMapping("/api/roomslots")
public class RoomSlotRESTController {

	@Autowired
	private RoomSlotRepository roomSlotRepository;
	
	// Get a list of room slots 
	@GetMapping
	public List<RoomSlot> getRoomSlots(){		
		return roomSlotRepository.findAll();
	}
	
	// Find available date
	@GetMapping("/{date}")
	public List<RoomSlot> findByDate(@PathVariable String date){
		return roomSlotRepository.findByDate(date);
	}
	
	// Find available date for reschedule appointment
	@GetMapping("/reschedule/{date}")
	public List<RoomSlot> findByDateReschedule(@PathVariable String date1){
		return roomSlotRepository.findByDateReschedule(date1);
	}
	
}
