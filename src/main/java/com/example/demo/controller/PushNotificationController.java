package com.example.demo.controller;
import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PushNotificationRequest;
import com.example.demo.model.PushNotificationResponse;
import com.example.demo.service.PushNotificationService;
@RestController
public class PushNotificationController {
	
	
    private PushNotificationService pushNotificationService;
    
    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }
    
    @PostMapping("/notification/token")
    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {
        String test=pushNotificationService.sendPushNotificationToToken(request);
        if(test.equalsIgnoreCase("mety"))
        {
            return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
        }
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Diso le token"), HttpStatus.NOT_FOUND);
    }
    
}