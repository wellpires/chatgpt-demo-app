package com.chatgpt.demoapp.service;

import com.chatgpt.demoapp.api.ChatGPTAPI;
import com.chatgpt.demoapp.dto.ChatGPTDetailDTO;
import com.chatgpt.demoapp.dto.DemoInputDTO;
import com.chatgpt.demoapp.dto.DemoOutputDTO;
import com.chatgpt.demoapp.dto.request.ChatGPTRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private ChatGPTAPI chatGPTAPI;

    @Override
    public DemoOutputDTO testChat(DemoInputDTO demoInputDTO) {

        ChatGPTDetailDTO chatGPTDetailDTO = ChatGPTDetailDTO.builder()
                .role("user")
                .content(demoInputDTO.getInput())
                .build();
        ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder()
                .model("gpt-3.5-turbo")
                .chatGPTDetails(Arrays.asList(chatGPTDetailDTO))
                .build();

        String output = chatGPTAPI.consumeApi(chatGPTRequest);
        return DemoOutputDTO.builder().output(output).build();
    }
}
