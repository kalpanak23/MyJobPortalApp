package com.JobPortalApp.JobPortalApp.Controller;

import com.JobPortalApp.JobPortalApp.Entity.Job;
import com.JobPortalApp.JobPortalApp.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;
    @PostMapping("/addJob")
    public ResponseEntity<Job> save(@RequestBody Job job){
        Job addedJob=jobService.saveDetails(job);
        return new ResponseEntity<Job>(addedJob, HttpStatus.CREATED);
    }
    public Job postDetails(@RequestBody Job job){
        return jobService.saveDetails(job);
    }
    @GetMapping("/getJob")
    public ResponseEntity<List<Job>> getDetails(){
        List<Job> jobs=jobService.getAllDetails();
        return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
    }

    @GetMapping("/getJobById/{id}")
    public Job fetchDetailsById(@PathVariable int id){
        return jobService.getJobDetailsById(id);
    }

//    @PutMapping("/updateJob")
//    public Job updateJobDetails(@RequestBody Job job){
//        return jobService.updateDetail(job);
//    }

    @PutMapping("/updateJob/{id}")
    public ResponseEntity<Job> updateJobDetails(@PathVariable Integer id, @RequestBody Job job) {
        Job updatedJob = jobService.updateJobDetails(id, job);
        return new ResponseEntity<>(updatedJob, HttpStatus.OK);
    }


    @DeleteMapping("/deleteJob/{id}")
    public ResponseEntity<String> deleteDetails(@PathVariable int id){
        jobService.deleteJob(id);

        return ResponseEntity.ok().build();
    }


}
