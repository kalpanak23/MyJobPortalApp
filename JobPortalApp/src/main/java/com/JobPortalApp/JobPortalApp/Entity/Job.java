package com.JobPortalApp.JobPortalApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Job_Details")
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Job_ID")
    private int id;
    @Column(name="Title")
    private String title;
    @Column(name="Company_Name")
    private  String company_name;
    @Column(name="Job_Type")
    private  String job_type;
    @Column(name="Eligibility")
    private  String eligibility;
    @Column(name="Skills")
    private String skills;
    @Column(name="Job_Description")
    private String description;
    @Column(name="Location")
    private String location;
    @Column(name="Contact")
    private int contact;

}
