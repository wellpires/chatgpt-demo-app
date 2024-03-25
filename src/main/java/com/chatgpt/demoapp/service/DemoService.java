package com.chatgpt.demoapp.service;

import com.chatgpt.demoapp.dto.DemoInputDTO;
import com.chatgpt.demoapp.dto.DemoOutputDTO;

public interface DemoService {
    DemoOutputDTO testChat(DemoInputDTO demoInputDTO);
}
