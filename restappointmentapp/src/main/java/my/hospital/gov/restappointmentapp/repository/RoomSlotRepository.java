package my.hospital.gov.restappointmentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import my.hospital.gov.restappointmentapp.model.RoomSlot;

@Repository
public interface RoomSlotRepository extends JpaRepository<RoomSlot, Long> {

	//@Query("SELECT r.roomSlotID , date FROM roomSlot r NATURAL JOIN appointment a WHERE r.roomSlotID  = a.roomSlotID ");
}
