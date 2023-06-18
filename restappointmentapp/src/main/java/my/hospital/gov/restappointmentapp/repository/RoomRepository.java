package my.hospital.gov.restappointmentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.hospital.gov.restappointmentapp.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
