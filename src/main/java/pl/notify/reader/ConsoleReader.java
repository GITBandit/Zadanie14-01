package pl.notify.reader;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.notify.model.Notification;

import java.util.List;
import java.util.Scanner;

public class ConsoleReader {

    public Notification readNotification (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe użytkownika");
        String user = scanner.nextLine();
        System.out.println("Podaj e-mail");
        String email = scanner.nextLine();
        System.out.println("Podaj nr telefonu");
        String phoneNr = scanner.nextLine();
        System.out.println("Podaj nr treść do wysłania");
        String notificationContent = scanner.nextLine();
        Notification notification = new Notification(user,email,phoneNr,notificationContent);

        return notification;
    }
}
