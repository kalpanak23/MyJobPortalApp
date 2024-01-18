package com.JobPortalApp.JobPortalApp.Service;

import com.JobPortalApp.JobPortalApp.Entity.Job;
import com.JobPortalApp.JobPortalApp.Repository.JobRepo;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;
    public Job saveDetails(Job job){
        return jobRepo.save(job);
    }
    public List<Job> getAllDetails(){
        return jobRepo.findAll();
    }

    public Job getJobDetailsById(int id){
        return jobRepo.findById(id).orElse(null);
    }
    public Job updateDetail(Job job){
        Job updateJob=jobRepo.findById(job.getId()).orElse(null);
        if(updateJob!=null){
            updateJob.setTitle(job.getCompany_name());
            updateJob.setCompany_name(job.getCompany_name());
            updateJob.setJob_type(job.getJob_type());
            updateJob.setEligibility(job.getEligibility());
            updateJob.setSkills(job.getSkills());
            updateJob.setDescription(job.getDescription());
            updateJob.setLocation(job.getLocation());
            updateJob.setContact(job.getContact());
            jobRepo.save(updateJob);
            return updateJob;
        }
        return null;
    }

    public String deleteJob(int id){
        if(jobRepo.existsById(id)){
            jobRepo.deleteById(id);
            return id+" Data deleted successfully.";
        }
        else {
            return "ID not present.";
        }
    }



}