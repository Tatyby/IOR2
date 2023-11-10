package com.example.ior.DTO;

import com.example.ior.Entity.CauseInstances;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class IncidentDTO {
    private String incidentId;
    private String sourceSystem;
    private String riskProfile;
    @Size(max = 500)
    private String incidentName;
    @Size(max = 2000)
    private String incidentDescription;
    @NotEmpty
    private String incidentStatus;
    @NotEmpty
    private String author;
    private String owner;
    private String verifier;
    @NotEmpty
    private LocalDateTime timeCreated;
    private LocalDateTime dateNotified;
    private LocalDateTime dateDiscovered;
    private LocalDateTime dateOfIncident;
    private LocalDateTime dateFinished;
    private LocalDateTime dateExpired;
    private LocalDateTime timeFirstValidated;
    private LocalDateTime timeLastValidated;
    @NotEmpty
    private String clientType;
    private List<CauseInstancesDTO> causeInstancesList;
}
