package org.jehack.flux.example.main.view;

import org.jehack.flux.example.main.model.MessageModel;

import java.util.Arrays;
import java.util.List;

public class MessageTemp {

    private List<MessageModel> messages;

    public MessageTemp() {

        MessageModel model1 = new MessageModel.Builder()
                .message("good")
                .build();

        MessageModel model2 = new MessageModel.Builder()
                .message("really")
                .build();

        MessageModel model3 = new MessageModel.Builder()
                .message("I think so too.")
                .build();

        messages = Arrays.asList(model1, model2, model3);

    }

    public List<MessageModel> getMessages() {
        return messages;
    }
}
