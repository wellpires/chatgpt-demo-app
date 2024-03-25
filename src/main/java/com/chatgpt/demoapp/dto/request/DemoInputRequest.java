package com.chatgpt.demoapp.dto.request;

import com.chatgpt.demoapp.dto.DemoInputDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemoInputRequest {

    @JsonProperty("demo-input")
    private DemoInputDTO demoInputDTO;

}
