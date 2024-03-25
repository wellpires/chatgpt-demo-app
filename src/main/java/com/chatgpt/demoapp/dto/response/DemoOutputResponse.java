package com.chatgpt.demoapp.dto.response;

import com.chatgpt.demoapp.dto.DemoOutputDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DemoOutputResponse {

    @JsonProperty("demo-output")
    private DemoOutputDTO demoOutputDTO;

}
