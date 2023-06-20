/**
 * 
 */
package my.hospital.gov.restappointmentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.hospital.gov.restappointmentapp.model.PatientAppointment;

@Repository
public interface PatientAppointmentRepository extends JpaRepository<PatientAppointment, Long> {



}
