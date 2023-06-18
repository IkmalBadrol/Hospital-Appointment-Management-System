package my.hospital.gov.restappointmentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.hospital.gov.restappointmentapp.model.Room;
import my.hospital.gov.restappointmentapp.repository.RoomRepository;

@RestController
@RequestMapping("/api/rooms")
public class RoomRESTController {

	@Autowired
	private RoomRepository roomRepository;
	
	@GetMapping
	public List<Room> getRooms(){
		return roomRepository.findAll();
	}
}
