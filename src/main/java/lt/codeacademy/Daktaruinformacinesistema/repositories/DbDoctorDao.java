package lt.codeacademy.Daktaruinformacinesistema.repositories;


import lt.codeacademy.Daktaruinformacinesistema.controller.Doctor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Primary
@Repository
public class DbDoctorDao implements DoctorDao {

    @Override
    public Optional<Doctor> getDoctor(Long id) {
        return Optional.ofNullable(
                jdbcTemplate.queryForobject("SELECT * FROM Doctors WHERE doctor_id = ?",
                        new Object[]{id},
                        (resultSet, rowNum) -> mapToProduct(resultSet, rowNum))
        );
    }

    @Override
    public boolean deleteDoctor(Long id) {
        return false;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        return null;
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return null;
    }
}
