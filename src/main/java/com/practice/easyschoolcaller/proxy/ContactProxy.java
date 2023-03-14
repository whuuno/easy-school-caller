package com.practice.easyschoolcaller.proxy;

import com.practice.easyschoolcaller.config.ProjectConfiguration;
import com.practice.easyschoolcaller.model.Contact;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "contact", url = "http://localhost:8080/api/contact",
    configuration = ProjectConfiguration.class)
public interface ContactProxy {

    @RequestMapping(path = "/getMessagesByStatus", method = RequestMethod.GET)
    @Headers(value = "Content-Type : application/json")
    public List<Contact> getMessagesByStatus(@RequestParam("status") String status);
}
