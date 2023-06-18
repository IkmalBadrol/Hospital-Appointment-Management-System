package my.hospital.gov.restappointmentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.hospital.gov.restappointmentapp.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {

}
