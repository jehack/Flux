package org.jehack.flux.example.main.model;


public class MessageModel {

    private String imageUrl;

    private String message;

    private MessageModel(Builder builder) {
        imageUrl = builder.imageUrl;
        message = builder.message;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getMessage() {
        return message;
    }

    public static final class Builder {
        private String imageUrl;
        private String message;

        public Builder() {
        }

        public Builder imageUrl(String val) {
            imageUrl = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public MessageModel build() {
            return new MessageModel(this);
        }
    }
}
