package org.example.notification_sender;

import org.example.notification.SmsNotification;

import java.util.List;
public class SmsNotificationSender implements NotificationSender<SmsNotification> {
    public SmsNotificationSender() {
    }

    @Override
    public void send(SmsNotification notification) {
        System.out.println(notification.formattedMessage());
    }

    @Override
    public void send(List<SmsNotification> list) {
        for (SmsNotification messages : list) {
            send(messages);

        }
    }
}