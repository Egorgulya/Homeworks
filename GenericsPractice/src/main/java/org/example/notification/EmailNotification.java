package org.example.notification;

import lombok.*;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmailNotification implements Notification {

    String themeOfMessage = "default";
    String message = "default";
    ArrayList<String> receivers = new ArrayList<>();

    @Override
    public String formattedMessage() {
        String formMessage;
        StringBuilder x = new StringBuilder();
        x.append(receivers);
        x.deleteCharAt(0);
        x.deleteCharAt(x.length()-1);
        formMessage = "Email"+ "\n" +
                "subject: "+ themeOfMessage +"\n"+
                "receivers: "+ x + "\n"+
                "message: "+ "<p>"+ message +"</p>";

        return formMessage;
    }
}