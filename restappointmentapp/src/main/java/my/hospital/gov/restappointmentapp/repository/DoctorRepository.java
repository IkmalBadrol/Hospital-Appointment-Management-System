package my.hospital.gov.restappointmentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import my.hospital.gov.restappointmentapp.model.Doctor;

/**
 * 
 * @author ikmalbadrol
 * This class contain the repository of doctors
 *
 */

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {

}
