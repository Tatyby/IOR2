package com.example.ior.service;

import com.example.ior.DTO.EmailRequest;
import com.example.ior.DTO.IncidentDTO;
import com.example.ior.Entity.IncidentEntity;
import com.example.ior.exception.IorException;
import com.example.ior.mapper.MyMapper;
import com.example.ior.repository.IorRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class IorServiceImp implements IorService {

    private final IorRepository iorRepository;
    private final JavaMailSenderImpl javaMailSender;
    private final MyMapper mapper;
    @Value("${file.upload.maxSizeMB}")
    private long maxFileSizeMB;


    public IorServiceImp(IorRepository iorRepository, JavaMailSenderImpl javaMailSender, MyMapper mapper) {
        this.iorRepository = iorRepository;
        this.javaMailSender = javaMailSender;
        this.mapper = mapper;
    }

    @Transactional
    public void create(IncidentDTO incidentDTO) {
        IncidentEntity incidentEntity = mapper.mapper(incidentDTO, IncidentEntity.class);
        iorRepository.save(incidentEntity);
    }

    @Transactional
    public void updateIor(String idIncident, IncidentDTO incidentDTO) {
        if (iorRepository.findById(idIncident).isEmpty()) {
            throw new IorException("Incident with ID: " + idIncident + "not found");
        } else {
            IncidentEntity incidentEntity = mapper.mapper(incidentDTO, IncidentEntity.class);
            iorRepository.save(incidentEntity);
        }
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

    @Transactional(readOnly = true)
    public Page<IncidentEntity> getAllIor(Specification<IncidentEntity> spec, Pageable pageable) {
        return iorRepository.findAll(spec, pageable);

    }
//
//    public void batchCreate(MultipartFile file) {
//        if (file.isEmpty()) {
//            throw new IorException("No file provided");
//        }
//        if (file.getSize() > maxFileSizeMB * 1024 * 1024) {
//            throw new IorException("file size exceeds the limit");
//        }
//        List<IncidentEntity> incidentEntityList = new ArrayList<>();
//    }
}
