package com.chatgpt.demoapp.api.impl;

import com.chatgpt.demoapp.api.ChatGPTAPI;
import com.chatgpt.demoapp.dto.request.ChatGPTRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ChatGPTAPIImpl implements ChatGPTAPI {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String consumeApi(ChatGPTRequest chatGPTRequest) {
        return restTemplate.postForEntity("https://api.openai.com/v1/chat/completions", chatGPTRequest, String.class).getBody();
    }
}
