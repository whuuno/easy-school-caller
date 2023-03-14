package com.practice.easyschoolcaller.rest;

import com.practice.easyschoolcaller.model.Contact;
import com.practice.easyschoolcaller.proxy.ContactProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/contact")
public class ContactController {

    @Autowired
    ContactProxy contactProxy;

    @GetMapping(path = "/getMessages")
    public List<Contact> getMessagesByStatus(@RequestParam("status") String status){
        return contactProxy.getMessagesByStatus(status);
    }
}
