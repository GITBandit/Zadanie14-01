package pl.notify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import pl.notify.app.NotificationFacade;
import pl.notify.logger.ConsoleLogger;
import pl.notify.logger.FileLogger;
import pl.notify.logger.NotifyLogger;
import pl.notify.reader.ConsoleNotificationReader;
import pl.notify.reader.FileNotificationReader;
import pl.notify.reader.NotificationReader;
import pl.notify.sender.EmailNotificationSender;
import pl.notify.sender.NotificationSender;
import pl.notify.sender.SMSNotificationSender;

//@Configuration
public class AppConfig {

    @Bean
    public NotifyLogger logger() {
        NotifyLogger logger = new ConsoleLogger();
        return logger;
    }

    @Bean
    public NotificationReader reader() {
        NotificationReader notificationReader = new ConsoleNotificationReader();
        return notificationReader;
    }

    @Bean
    public NotificationSender sender() {
        NotificationSender notificationSender = new SMSNotificationSender();
        return notificationSender;
    }

    @Bean
    public NotificationFacade facade(NotifyLogger logger, NotificationReader reader, NotificationSender sender) {
        NotificationFacade notificationFacade = new NotificationFacade(reader, sender, logger);
        return notificationFacade;
    }

}
