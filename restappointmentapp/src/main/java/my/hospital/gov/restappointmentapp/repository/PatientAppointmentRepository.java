/**
 * 
 */
package my.hospital.gov.restappointmentapp.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import my.hospital.gov.restappointmentapp.model.PatientAppointment;

@Repository
public interface PatientAppointmentRepository extends JpaRepository<PatientAppointment, Long> {

//	@Query(value = "select date from appointment where date != :date", nativeQuery = true)
//	List<PatientAppointment> findByDate(@Param("date") Date date );
}
