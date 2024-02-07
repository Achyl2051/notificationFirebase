package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.model.PushNotificationRequest;
@Service
public class PushNotificationService {
	
    private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);
    
    private FCMService fcmService;
    
    public PushNotificationService(FCMService fcmService) {
        this.fcmService = fcmService;
    }
    
    
    public String sendPushNotificationToToken(PushNotificationRequest request) {
        try {
            fcmService.sendMessageToToken(request);
            return "mety";
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "tsy mety";
        }
    }
   
}