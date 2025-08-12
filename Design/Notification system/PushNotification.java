public class PushNotification implements NotificationChannel {
    
    @Override
    public void sendNotification(NotificationRequest request)
    {
        System.out.println("Notificaton sent via Push Notification");
    }
}
