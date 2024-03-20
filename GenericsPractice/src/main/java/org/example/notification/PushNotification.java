package org.example.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PushNotification implements Notification{


    String message = "default";
    String title = "default";
    String receiver = "default";


    @Override
    public String formattedMessage() {
        String formMessage;
        formMessage ="PUSH"+ "\n" +
                "title: "+ title +"\n"+
                "receivers: "+ receiver + "\n"+
                "message: "+ "\uD83D\uDC4B" +message;
        return formMessage;
    }
}