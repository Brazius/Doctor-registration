package lt.codeacademy.Daktaruinformacinesistema.controller;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctor_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "region")
    private String region;

}
