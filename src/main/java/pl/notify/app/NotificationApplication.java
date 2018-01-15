package pl.notify.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.notify.logger.ConsoleLogger;
import pl.notify.logger.FileLogger;
import pl.notify.logger.NotifyLogger;
import pl.notify.reader.ConsoleNotificationReader;
import pl.notify.reader.FileNotificationReader;
import pl.notify.reader.NotificationReader;
import pl.notify.sender.EmailNotificationSender;
import pl.notify.sender.NotificationSender;
import pl.notify.sender.SMSNotificationSender;

import java.io.IOException;

/**
 * Konfiguracja beanów springa w pliku beans-config.xml
 */
public class NotificationApplication {
    public static void main(String[] args) {
        NotificationReader reader = new ConsoleNotificationReader();
        NotificationSender sender = new SMSNotificationSender();
        NotifyLogger logger = new ConsoleLogger();
        NotificationFacade facade = new NotificationFacade(reader, sender, logger);
        try {
            facade.sendNotifications();
        } catch (IOException e) {
            System.err.println("Nie udało się wysłać powiadomień");
        }
    }
}
