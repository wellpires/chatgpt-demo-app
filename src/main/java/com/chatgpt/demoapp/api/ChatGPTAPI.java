package com.chatgpt.demoapp.api;

import com.chatgpt.demoapp.dto.request.ChatGPTRequest;
import com.chatgpt.demoapp.dto.response.ChatCompletionResponse;

public interface ChatGPTAPI {

    ChatCompletionResponse consumeApi(ChatGPTRequest chatGPTRequest);

}
