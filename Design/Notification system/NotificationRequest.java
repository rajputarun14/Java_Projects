import java.util.ArrayList;
import java.util.List;

public class NotificationRequest{
    String id;
    String message;
    long number;
    String email;
    List<ChannelType> channels;


    public NotificationRequest(String message, String email, long number)
    {
        this.message = message;
        this.email = email;
        this.number = number;
        channels = new ArrayList<>();
    }

    public String getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }
    public long getNumber() {
        return number;
    }
    public String getEmail() {
        return email;
    }
    public List<ChannelType> getChannels() {
        return channels;
    }
    public void addChannel(ChannelType type)
    {
        channels.add(type);
    }
    
}