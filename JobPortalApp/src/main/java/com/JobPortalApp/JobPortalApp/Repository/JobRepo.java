package com.JobPortalApp.JobPortalApp.Repository;

import com.JobPortalApp.JobPortalApp.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job,Integer> {
}
