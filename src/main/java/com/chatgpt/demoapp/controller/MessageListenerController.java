package com.chatgpt.demoapp.controller;

import com.chatgpt.demoapp.service.MessageListenerService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MessageListenerController {

    @Autowired
    private MessageListenerService messageListenerService;

    @PostMapping(path = "/webhook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> receiveMessage(@RequestBody JsonNode body) {
        System.out.println(body.toPrettyString());
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/webhook")
    public ResponseEntity<String> verificateRequest(  @RequestParam("hub.mode") String mode,
                                                    @RequestParam("hub.challenge") String challenge,
                                                    @RequestParam("hub.verify_token") String verifyToken) {

        int status = messageListenerService.verifyRequest(mode, verifyToken);
        return ResponseEntity.status(status).body(challenge);
    }

    @GetMapping(path = "/")
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("O que vc tá procurando aqui?! Não tem nada");
    }

}
