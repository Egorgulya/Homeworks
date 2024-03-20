package org.example.notification_sender;

import org.example.notification.EmailNotification;

import java.util.List;

public class EmailNotificationSender implements NotificationSender<EmailNotification> {


    public EmailNotificationSender() {

    }

    @Override
    public void send(EmailNotification notification) {
        System.out.println(notification.formattedMessage());

    }

    @Override
    public void send(List<EmailNotification> list) {
        for (EmailNotification messages : list) {
            send(messages);
        }
    }
}