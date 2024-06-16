package com.chatgpt.demoapp.service;

import com.chatgpt.demoapp.api.ChatGPTAPI;
import com.chatgpt.demoapp.dto.*;
import com.chatgpt.demoapp.dto.request.ChatGPTRequest;
import com.chatgpt.demoapp.dto.response.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

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


        ChatCompletionResponse chatCompletionResponse = chatGPTAPI.consumeApi(chatGPTRequest);
        String output = chatCompletionResponse.getChoices().stream()
                .map(ChoiceDTO::getMessage)
                .map(MessageDTO::getContent)
                .collect(Collectors.joining("\n"));
        return DemoOutputDTO.builder().output(output).build();
    }
}
