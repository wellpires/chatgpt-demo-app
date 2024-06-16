package com.chatgpt.demoapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChoiceDTO {
    private int index;
    private MessageDTO message;

    @JsonProperty("finish_reason")
    private String finishReason;
}
