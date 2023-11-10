package com.example.ior.DTO;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CauseInstancesDTO {
    private String causeId;
    private LocalDateTime timeCreated;

}
