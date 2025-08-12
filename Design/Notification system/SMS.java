public class SMS  implements NotificationChannel{
    @Override
    public void sendNotification(NotificationRequest request)
    {
        System.out.println("Notification sent via SMS");
    }
}
