package org.example;

import org.example.notification.EmailNotification;
import org.example.notification.PushNotification;
import org.example.notification.SmsNotification;
import org.example.notification_sender.EmailNotificationSender;
import org.example.notification_sender.NotificationSender;
import org.example.notification_sender.PushNotificationSender;
import org.example.notification_sender.SmsNotificationSender;
import java.util.ArrayList;


public class Main {
    public static String message = "Спасибо за регистрацию на сервисе!";
    public static String theme = "Успешная регистрация!";
    public static void main(String[] args) {
        EmailSending();
        smsSending();
        pushSending();

    }
    public static void EmailSending(){

        ArrayList<String> emailReceivers = new ArrayList<>();
        emailReceivers.add("jojo@mail.com");
        emailReceivers.add("beemoo@mail.com");
        EmailNotification byEmail = new EmailNotification(theme, message, emailReceivers);     // сообщение-образец для одиночной отправки Емейл



        EmailNotification byEmail2 = new EmailNotification();                                    // сообщение для проверки работы отправки множества сообщений

        ArrayList<String> emailReceivers3 = new ArrayList<>();
        emailReceivers3.add("wowoowow@mail.ru");
        emailReceivers3.add("Yoynk@c.su");
        EmailNotification byEmail3 = new EmailNotification("Тест","Тест",emailReceivers3);

        ArrayList<EmailNotification> moreEmailNotifications = new ArrayList<>();
        moreEmailNotifications.add(byEmail3);
        moreEmailNotifications.add(byEmail2);

        NotificationSender<EmailNotification> emailSender = new EmailNotificationSender();                    // создание "отправщика" и сначала отправка одного сообщения, затем множества сообщений
        emailSender.send(byEmail);
        emailSender.send(moreEmailNotifications);
    }
    public static void smsSending(){
        ArrayList<String> smsReceivers = new ArrayList<>();
        smsReceivers.add("89262777777");
        smsReceivers.add("88005555555");
        SmsNotification bySMS = new SmsNotification(message, smsReceivers);                    //сообщение-образец для одиночной отправки СМС

        SmsNotification bySMS2 = new SmsNotification();
        ArrayList<String> smsReceivers2 = new ArrayList<>();
        smsReceivers2.add("02");
        SmsNotification bySMS3 = new SmsNotification("Тест",smsReceivers2);
        ArrayList<SmsNotification> moreSMSNotifications = new ArrayList<>();                   // сообщение для проверки работы отправки множества сообщений

        NotificationSender<SmsNotification> smsSender = new SmsNotificationSender();                          //// создание "отправщика" и сначала отправка одного сообщения, затем множества сообщений
        moreSMSNotifications.add(bySMS3);
        moreSMSNotifications.add(bySMS2);
        smsSender.send(bySMS);
        smsSender.send(moreSMSNotifications);
    }
    public static void pushSending(){
        String receiver = "ou.my";
        PushNotification byPush = new PushNotification(message,theme,receiver);           // создаем сообщение - образец ПУШ
        PushNotification byPush2 = new PushNotification();                                // cообщение для проверки работы отправки множества сообщений
        PushNotification byPush3 = new PushNotification("Тест","Тест","Тест");
        ArrayList<PushNotification> morePushNotification = new ArrayList<>();
        morePushNotification.add(byPush3);
        morePushNotification.add(byPush2);
        NotificationSender<PushNotification> pushSender = new PushNotificationSender();
        pushSender.send(byPush);
        pushSender.send(morePushNotification);

    }

}
