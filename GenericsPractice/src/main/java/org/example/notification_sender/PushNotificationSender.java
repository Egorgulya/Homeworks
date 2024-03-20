package org.example.notification_sender;

import org.example.notification.PushNotification;

import java.util.List;

public class PushNotificationSender implements NotificationSender<PushNotification>{


    @Override
    public void send(PushNotification notification) {
        System.out.println(notification.formattedMessage());

    }

    @Override
    public void send(List<PushNotification> list) {
        for (PushNotification messages : list){
            send(messages);
        }
    }
}