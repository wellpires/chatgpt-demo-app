package com.chatgpt.demoapp.dto.request;

import com.chatgpt.demoapp.dto.ChatGPTDetailDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPTRequest {

    private String model;

    @JsonProperty("messages")
    private List<ChatGPTDetailDTO> chatGPTDetails;

}
