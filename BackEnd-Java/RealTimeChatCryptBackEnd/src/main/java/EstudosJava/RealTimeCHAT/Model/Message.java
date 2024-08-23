package EstudosJava.RealTimeCHAT.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Message {
    private String sender;
    private String chatId;
    private String content;
}


