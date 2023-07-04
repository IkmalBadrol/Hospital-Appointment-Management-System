package my.hospital.gov.restappointmentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import my.hospital.gov.restappointmentapp.model.PatientDetail;
import my.hospital.gov.restappointmentapp.model.RoomSlot;

/**
 * 
 * @author ikmalbadrol
 * This class contain the repository of room slot
 *
 */
@Repository
public interface RoomSlotRepository extends JpaRepository<RoomSlot, String> {

	// Check available room slot for selected appointment date
	@Query(value = "SELECT rs.* FROM roomslot rs "  
				  + " LEFT JOIN (SELECT roomSlotID, appointmentID from appointment WHERE date = :date) a"
			      + " ON a.roomSlotID = rs.roomSlotID WHERE a.appointmentID IS NULL", nativeQuery = true)
	
	public List<RoomSlot> findByDate(@Param("date") String date);
	
	
	@Query(value = "SELECT rs1.* FROM roomslot rs1 "  
			  + " LEFT JOIN (SELECT roomSlotID, appointmentID from appointment WHERE date = :date) a1"
		      + " ON a1.roomSlotID = rs1.roomSlotID WHERE a1.appointmentID IS NULL", nativeQuery = true)

	public List<RoomSlot> findByDateReschedule(@Param("date") String date1);
	
}
