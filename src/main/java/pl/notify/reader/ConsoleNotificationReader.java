package pl.notify.reader;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.notify.model.Notification;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Component
@Primary
public class ConsoleNotificationReader implements NotificationReader{

    @Override
    public List<Notification> getNotifications() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ConsoleReader consoleReader = new ConsoleReader();
        List<Notification> notificationList = new LinkedList<>();
        System.out.println("Wpisz NEXT aby dodać powiadomienie lub EXIT aby zakończyć");
        boolean loop = true;
        while (loop){
            switch (scanner.nextLine()) {
                case "NEXT":
                    notificationList.add(consoleReader.readNotification());
                    break;
                case "EXIT":
                    loop = false;
                    break;
                default:
                    loop = false;
                    break;

            }
        }
        scanner.close();
        return notificationList;
    }


}
