package org.example.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SmsNotification implements Notification{

    String message = "default";
    ArrayList<String> receivers = new ArrayList<>();



    @Override
    public String formattedMessage() {
        String formMessage;
        StringBuilder x = new StringBuilder();
        x.append(receivers);
        x.deleteCharAt(0);
        x.deleteCharAt(x.length()-1);
        formMessage = "SMS"+ "\n" +
                "receivers: "+ x + "\n"+
                "message: "+message;
        return formMessage;
    }
}