package org.example.notification_sender;


import org.example.notification.Notification;

import java.util.List;


public interface NotificationSender<T extends Notification> {


    void send(T notification);



    void send(List<T> notifications);
}