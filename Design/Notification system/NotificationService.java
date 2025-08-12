import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationService {
    Map<ChannelType, NotificationChannel> channelTypeMap = new HashMap<>();
    public NotificationService()
    {
        channelTypeMap.put(ChannelType.EMAIL, new Email());
        channelTypeMap.put(ChannelType.SMS, new SMS());
        channelTypeMap.put(ChannelType.PUSH, new PushNotification());
    }

    public void sendNotification(NotificationRequest request)
    {
       List<ChannelType> channels  = request.getChannels();
       for(ChannelType channel : channels)
       {
            channelTypeMap.get(channel).sendNotification(request);
       }
    }

    public static void main(String[] args) {
        NotificationRequest amazon = new NotificationRequest("Hi, Your order from Amazon of Speedo Glasses has been placed, Order id : 1231234", "rajputarun14@gmail.com", 8937066545L);
        amazon.addChannel(ChannelType.EMAIL);
        amazon.addChannel(ChannelType.SMS);

        NotificationService service = new NotificationService();
        service.sendNotification(amazon);

    }
}
