package com.example.ior.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

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
    @NotEmpty
    private String sourceSystem;
    @Schema(description = "Идентификатор ЦПР")
    private String riskProfile;
    @Schema(description = "Название инцидента")
    @Size(max = 500)
    private String incidentName;
    @Schema(description = "Описание инцидента")
    @Size(max = 2000)
    private String incidentDescription;
    @Schema(description = "Статус инцидента")
    @NotEmpty
    private String incidentStatus;
    @Schema(description = "Идентификатор сотрудника, создавшего инцидент")
    @NotEmpty
    private String author;
    @Schema(description = "Идентификатор сотрудника, расследующего инцидент")
    private String owner;
    @Schema(description = "Идентификатор сотрудника, утверждающего инцидент")
    private String verifier;
    @Schema(description = "Дата и время создания записи")
    @NotEmpty
    private LocalDateTime timeCreated;
    @Schema(description = "Дата первичного информирования об инциденте")
    private LocalDateTime dateNotified;
    @Schema(description = "Дата обнаружения")
    private LocalDateTime dateDiscovered;
    @Schema(description = "Дата начала события")
    private LocalDateTime dateOfIncident;
    @Schema(description = "Дата окончания события")
    private LocalDateTime dateFinished;
    @Schema(description = "Срок исполнения для текущего этапа процесса")
    private LocalDateTime dateExpired;
    @Schema(description = "Дата и время первого утверждения")
    private LocalDateTime timeFirstValidated;
    @Schema(description = "Дата и время последнего утверждения")
    private LocalDateTime timeLastValidated;
    @Schema(description = "Тип клиента")
    @NotEmpty
    private String clientType;
    @OneToMany(mappedBy = "incident", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CauseInstances> causeInstancesList;


}
