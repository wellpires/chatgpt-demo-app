package com.chatgpt.demoapp.controller;

import com.chatgpt.demoapp.dto.DemoOutputDTO;
import com.chatgpt.demoapp.dto.request.DemoInputRequest;
import com.chatgpt.demoapp.dto.response.DemoOutputResponse;
import com.chatgpt.demoapp.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping(path = "test", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DemoOutputResponse> test(@RequestBody DemoInputRequest demoInputRequest){

        DemoOutputDTO demoOutputDTO =  demoService.testChat(demoInputRequest.getDemoInputDTO());

        return ResponseEntity.ok(DemoOutputResponse.builder().demoOutputDTO(demoOutputDTO).build());

    }



}
