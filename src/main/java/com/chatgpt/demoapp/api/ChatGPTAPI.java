package com.chatgpt.demoapp.api;

import com.chatgpt.demoapp.dto.request.ChatGPTRequest;

public interface ChatGPTAPI {

    String consumeApi(ChatGPTRequest chatGPTRequest);

}
