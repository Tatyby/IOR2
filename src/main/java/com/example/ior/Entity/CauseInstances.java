package com.example.ior.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "cause_instances")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class CauseInstances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор причины.Рассчитывается внутри Сбер ОРМ как Идентификатор инцидента + '-C' + порядковый номер возмещения в инциденте (с учетом удаленных причин).")
    private String causeId;
    @Schema(description = "Дата создания")
    private LocalDateTime timeCreated;
    @Schema(description = "Идентификатор сотрудника, создавшего последствие.")
    private String author;
    @ManyToOne()
    @JoinColumn(name = "incident_Id")
    private IncidentEntity incident;
}
