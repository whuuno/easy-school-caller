package com.practice.easyschoolcaller.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Contact {
    private int contactId;
    private String name;
    private String mobileNum;
    private String email;
    private String subject;
    private String message;
    private String status;
}
