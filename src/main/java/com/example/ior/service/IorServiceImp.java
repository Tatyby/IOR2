package com.example.ior.service;

import com.example.ior.DTO.EmailRequest;
import com.example.ior.Entity.IncidentEntity;
import com.example.ior.repository.IorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IorServiceImp implements IorService {

    private final IorRepository iorRepository;
    private final JavaMailSenderImpl javaMailSender;

    public IorServiceImp(IorRepository iorRepository, JavaMailSenderImpl javaMailSender) {
        this.iorRepository = iorRepository;
        this.javaMailSender = javaMailSender;
    }

    public void create(IncidentEntity incidentEntity) {
        iorRepository.save(incidentEntity);
    }

    public void sendEmail(EmailRequest emailRequest, IncidentEntity incidentEntity) {
        if (incidentEntity.getDateExpired().isAfter(LocalDateTime.now())) {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(emailRequest.getEmailAdress());
            mailMessage.setSubject(emailRequest.getSubject());
            mailMessage.setText(emailRequest.getBody());
            javaMailSender.send(mailMessage);
        }
    }

    public Page<IncidentEntity> getAllIor(Specification<IncidentEntity> spec, Pageable pageable) {
        return iorRepository.findAll(spec, pageable);

    }
}
