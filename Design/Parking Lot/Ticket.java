import java.util.Date;

public class Ticket {
    private String ticketId;
    private Date entryTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSlot parkingSlot) {
        this.ticketId = ticketId;
        this.entryTime = new Date();
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }
    
}
