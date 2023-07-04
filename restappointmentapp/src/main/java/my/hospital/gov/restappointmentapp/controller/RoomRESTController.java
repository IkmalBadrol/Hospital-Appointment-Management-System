package my.hospital.gov.restappointmentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.hospital.gov.restappointmentapp.model.Room;
import my.hospital.gov.restappointmentapp.repository.RoomRepository;

/**
 * 
 * @author ikmalbadrol
 * This class is for the REST Controller for room
 * This class to the web method to get list of all rooms
 */

@RestController
@RequestMapping("/api/rooms")
public class RoomRESTController {

	@Autowired
	private RoomRepository roomRepository;
	
	// Get a list of rooms
	@GetMapping
	public List<Room> getRooms(){
		
		return roomRepository.findAll();
	}
}
