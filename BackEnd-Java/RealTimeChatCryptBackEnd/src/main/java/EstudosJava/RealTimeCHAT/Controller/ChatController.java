package EstudosJava.RealTimeCHAT.Controller;

import EstudosJava.RealTimeCHAT.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @Autowired
    private MessageSendingOperations<String> messagingTemplate;

    @MessageMapping("/sendMessage")
    public Message sendMessage(@Payload Message chatMessage) {
        String chatCode = chatMessage.getChatId();
        messagingTemplate.convertAndSend("/topic/"+chatCode, chatMessage);
        return chatMessage;
    }

}
