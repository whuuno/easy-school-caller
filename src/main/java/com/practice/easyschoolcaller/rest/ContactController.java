package com.practice.easyschoolcaller.rest;

import com.practice.easyschoolcaller.model.Contact;
import com.practice.easyschoolcaller.model.Response;
import com.practice.easyschoolcaller.proxy.ContactProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "/api/contact")
public class ContactController {

    @Autowired
    ContactProxy contactProxy;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(path = "/getMessages")
    public List<Contact> getMessagesByStatus(@RequestParam("status") String status){
        return contactProxy.getMessagesByStatus(status);
    }

    @PostMapping(path = "/saveMsg")
    public ResponseEntity<Response> saveMsg(@RequestBody Contact contact){
        String uri = "http://localhost:8080/api/contact/saveMsg";
        HttpHeaders headers = new HttpHeaders();
        headers.add("invocationFrom","RestTemplate");
        HttpEntity<Contact> httpEntity = new HttpEntity<>(contact, headers);
        ResponseEntity<Response> responseEntity = restTemplate.exchange(uri, HttpMethod.POST,
                httpEntity,Response.class);
        return responseEntity;
    }
}
