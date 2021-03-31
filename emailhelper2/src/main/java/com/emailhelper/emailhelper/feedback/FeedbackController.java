package com.emailhelper.emailhelper.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emailhelper.emailhelper.model.FeedbackDto;
import com.emailhelper.emailhelper.repository.FeedbackDtoRepository;

import javax.validation.ValidationException;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackDtoRepository feedbackDtoRepository;

    private EmailCfg emailCfg;

    public FeedbackController(EmailCfg emailCfg) {
        this.emailCfg = emailCfg;
    }

    
    @PostMapping(value="/send", consumes=MediaType.APPLICATION_JSON_VALUE)
    public void sendFeedback(@RequestBody FeedbackDto feedback,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException("Feedback is not valid");
        }

        // Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUsername());
        mailSender.setPassword(this.emailCfg.getPassword());

        // Create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("rc@feedback.com");
        mailMessage.setTo(feedback.getAdress());
        mailMessage.setSubject(feedback.getSubject());
        mailMessage.setText(feedback.getContent());

        // Send mail
        mailSender.send(mailMessage);
        
        this.feedbackDtoRepository.save(feedback);
    }
}
