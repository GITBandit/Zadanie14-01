package pl.notify.sender;

import pl.notify.model.Notification;

public interface NotificationSender {

    public void send(Notification notification);
}
