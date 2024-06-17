package com.chatgpt.demoapp.api.impl;

import com.chatgpt.demoapp.api.ChatGPTAPI;
import com.chatgpt.demoapp.dto.request.ChatGPTRequest;
import com.chatgpt.demoapp.dto.response.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ChatGPTAPIImpl implements ChatGPTAPI {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ChatCompletionResponse consumeApi(ChatGPTRequest chatGPTRequest) {
        return restTemplate.postForEntity("https://api.openai.com/v1/chat/completions", chatGPTRequest, ChatCompletionResponse.class).getBody();
    }

}
