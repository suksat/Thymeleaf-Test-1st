package com.example.application.repository;

import com.example.application.modelDTO.Submission;
import org.springframework.data.repository.CrudRepository;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {
}
