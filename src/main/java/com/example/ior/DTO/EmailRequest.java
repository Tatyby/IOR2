package com.example.ior.DTO;

import lombok.Data;

@Data
public class EmailRequest {
    private String emailAdress;
    private String subject;
    private String body;
}
