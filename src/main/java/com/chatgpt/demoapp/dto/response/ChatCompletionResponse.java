package com.chatgpt.demoapp.dto.response;

import com.chatgpt.demoapp.dto.ChoiceDTO;
import com.chatgpt.demoapp.dto.UsageDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class ChatCompletionResponse {
    private String id;

    @JsonProperty("object")
    private String objectType;

    private long created;
    private String model;
    private List<ChoiceDTO> choices;
    private UsageDTO usage;

    @JsonProperty("system_fingerprint")
    private String systemFingerprint;
}
