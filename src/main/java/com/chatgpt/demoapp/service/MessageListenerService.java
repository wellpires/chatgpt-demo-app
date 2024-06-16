package com.chatgpt.demoapp.service;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MessageListenerService {

    @Value("${meta.whatsapp.webhook_verify_token}")
    private String webhookVerifyToken;

    public int verifyRequest(String mode, String verifyToken) {

        if ("subscribe".equals(mode) && !webhookVerifyToken.equals(verifyToken)){
            log.info("Webhook verified successfully!");
            return 200;
        } else{
            log.error("Webhook not verified!");
            return 403;
        }

        // check the mode and token sent are correct
//        if (mode === "subscribe" && token === WEBHOOK_VERIFY_TOKEN) {
//            // respond with 200 OK and challenge token from the request
//            res.status(200).send(challenge);
//            console.log("Webhook verified successfully!");
//        } else {
//            // respond with '403 Forbidden' if verify tokens do not match
//            res.sendStatus(403);
//        }

    }
}
