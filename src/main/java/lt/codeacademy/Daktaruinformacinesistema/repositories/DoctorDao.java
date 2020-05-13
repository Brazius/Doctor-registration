package lt.codeacademy.Daktaruinformacinesistema.repositories;

import lt.codeacademy.Daktaruinformacinesistema.controller.Doctor;

import java.util.Optional;

public interface DoctorDao {

    Optional<Doctor> getDoctor(Long id);

    boolean deleteDoctor(Long id);

    Doctor updateDoctor(Doctor doctor);

    Doctor createDoctor(Doctor doctor);
}
