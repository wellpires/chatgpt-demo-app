package com.chatgpt.demoapp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WhatsAppBusinessAccountRequest {
    private String object;
    private List<EntryDTO> entry;

    @Data
    public static class EntryDTO {
        private String id;
        private List<ChangeDTO> changes;

        @Data
        public static class ChangeDTO {
            private ValueDTO value;
            private String field;

            @Data
            public static class ValueDTO {
                private String messagingProduct;
                private MetadataDTO metadata;
                private List<ContactDTO> contacts;
                private List<MessageDTO> messages;

                @Data
                public static class MetadataDTO {
                    private String displayPhoneNumber;

                    @JsonProperty("phone_number_id")
                    private String phoneNumberId;
                }

                @Data
                public static class ContactDTO {
                    private ProfileDTO profile;

                    @JsonProperty("wa_id")
                    private String waId;

                    @Data
                    public static class ProfileDTO {
                        private String name;
                    }
                }

                @Data
                public static class MessageDTO {
                    private String from;
                    private String id;
                    private String timestamp;
                    private TextDTO text;
                    private String type;

                    @Data
                    public static class TextDTO {
                        private String body;
                    }
                }
            }
        }
    }
}
