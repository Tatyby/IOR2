package com.example.ior.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "incident")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class IncidentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор инцидента")
    private String incidentId;
    @Schema(description = "Исходная система инцидента")
    private String sourceSystem;
    @Schema(description = "Идентификатор ЦПР")
    private String riskProfile;
    @Schema(description = "Название инцидента")
    private String incidentName;
    @Schema(description = "Описание инцидента")
    private String incidentDescription;
    @Schema(description = "Статус инцидента")
    private String incidentStatus;
    @Schema(description = "Идентификатор сотрудника, создавшего инцидент")
    private String author;
    @Schema(description = "")
    private String owner;
    @Schema(description = "")
    private String verifier;
    @Schema(description = "")
    private Date timeCreated;
    @Schema(description = "")
    private Date dateNotified;
    @Schema(description = "")
    private Date dateDiscovered;
    @Schema(description = "")
    private Date dateOfIncident;
    @Schema(description = "")
    private Date dateFinished;
    @Schema(description = "")
    private Date dateExpired;
    @Schema(description = "")
    private Date timeFirstValidated;
    @Schema(description = "")
    private Date timeLastValidated;
    @Schema(description = "")
    private Date clientType;













}
