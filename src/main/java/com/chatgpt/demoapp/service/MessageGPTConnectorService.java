package com.chatgpt.demoapp.service;

import com.chatgpt.demoapp.api.ChatGPTAPI;
import com.chatgpt.demoapp.dto.request.WhatsAppBusinessAccountRequest;
import com.chatgpt.demoapp.dto.request.WhatsAppBusinessAccountRequest.EntryDTO.ChangeDTO.ValueDTO.MessageDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MessageGPTConnectorService {


    @Autowired
    private ChatGPTAPI chatGPTAPI;

    public void start(WhatsAppBusinessAccountRequest whatsAppBusinessAccountRequest) throws Exception {

        MessageDTO messageDTO = whatsAppBusinessAccountRequest
                .getEntry().stream().findFirst().orElseThrow(Exception::new)
                .getChanges().stream().findFirst().orElseThrow(Exception::new)
                .getValue()
                .getMessages().stream().findFirst().orElseThrow(Exception::new);


        if ("text".equals(messageDTO.getType())) {

            log.info("Incoming message {}", messageDTO.getText());

            String businessPhoneNumberId = whatsAppBusinessAccountRequest
                    .getEntry().stream().findFirst().orElseThrow(Exception::new)
                    .getChanges().stream().findFirst().orElseThrow(Exception::new)
                    .getValue()
                    .getMetadata()
                    .getPhoneNumberId();

//               const response = await axios({
//                    method: "POST",
//                    url: `https://chatgpt-demo-app-852e0d52d8b6.herokuapp.com/demo/test`,
//            data: {
//                'demo-input': {"input": message.text.body}
//            },
//    });


        }
//        const message = req.body.entry?.[0]?.changes[0]?.value?.messages?.[0];

    }


}
