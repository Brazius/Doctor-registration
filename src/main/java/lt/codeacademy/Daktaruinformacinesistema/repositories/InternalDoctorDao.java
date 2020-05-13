package lt.codeacademy.Daktaruinformacinesistema.repositories;

import lt.codeacademy.Daktaruinformacinesistema.controller.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InternalDoctorDao implements DoctorDao {

    private List<Doctor> doctors;

    public InternalDoctorDao() {
        this.doctors = buildDoctors();
    }

    private List<Doctor> buildDoctors() {
        Doctor doctors2 = new Doctor();
        doctors2.setId(2L);
        doctors2.setFirstName("Ai");
        doctors2.setLastName("Skauda");
        doctors2.setRegion("Kaverskas");
        doctors2.setSpecialization("akuseris");

        Doctor doctors3 = new Doctor();
        doctors3.setId(3L);
        doctors3.setFirstName("Ai");
        doctors3.setLastName("Skauda");
        doctors3.setRegion("Kaverskas");
        doctors3.setSpecialization("akuseris");

        Doctor doctors4 = new Doctor();
        doctors4.setId(4L);
        doctors4.setFirstName("Ai");
        doctors4.setLastName("Skauda");
        doctors4.setRegion("Kaverskas");
        doctors4.setSpecialization("akuseris");

        List<Doctor> doctors = new ArrayList<>();
        doctors.add(doctors2);
        doctors.add(doctors3);
        doctors.add(doctors4);

        return doctors;
    }

    @Override
    public Optional<Doctor> getDoctor(Long id) {
        return doctors.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean deleteDoctor(Long id) {
        List<Doctor> newlist = doctors.stream()
                .filter(p -> !p.getId().equals(id))
                .collect(Collectors.toList());

        boolean deleted = newlist.size() != doctors.size();

        return deleted;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        getDoctor(doctor.getId()).ifPresent(existingDoctor -> {
            existingDoctor.setSpecialization(doctor.getSpecialization());
            existingDoctor.setRegion(doctor.getRegion());
            existingDoctor.setFirstName(doctor.getFirstName());
            existingDoctor.setLastName(doctor.getLastName());
        });
        return doctor;
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        Long maxId = doctors.stream()
                .mapToLong(Doctor::getId)
                .max().orElse(0L);

        doctor.setId(maxId + 1);
        doctors.add(doctor);
        return null;
    }

}
