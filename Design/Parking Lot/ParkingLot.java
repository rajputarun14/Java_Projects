import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
    private List<ParkingFloor> floors;
    private Map<String, Ticket> vehicleToSlotMap;

    public ParkingLot(){
        this.floors = new ArrayList<>();
        this.vehicleToSlotMap = new HashMap<>();
    }
    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }
    public int getNumberOfFloors()
    {
        return floors.size();
    }
    public Ticket parkVehicle(Vehicle vehicle)
    {
        SlotType slotType = getPreferredSlot(vehicle.getVehicleType());
        for(ParkingFloor floor : floors)
        {
            ParkingSlot slot = floor.findAvailableSlot(slotType);
            if(slot != null)
            {
                slot.occupySlot();
                Ticket ticket = new Ticket(UUID.randomUUID().toString() , vehicle, slot);
                vehicleToSlotMap.put(ticket.getTicketId(), ticket);
                System.out.println("Parked at slot : " + slot.getSlotId() + " Floor: "+ slot.getParkingFloor());
                return ticket;
            }
        }
        return null;
    }
    public void unparkVehicle(String ticketId)
    {
        if(vehicleToSlotMap.containsKey(ticketId))
        {
            Ticket ticket = vehicleToSlotMap.get(ticketId);
            ParkingSlot slot = ticket.getParkingSlot();
            slot.vacantSlot();
            vehicleToSlotMap.remove(ticketId);
            System.out.println("Vehicle unparked from slot : " + slot.getSlotId());
        }
        else{
             System.out.println("No vehicle parked with such ticketId");
        }
    }
    public SlotType getPreferredSlot(VehicleType type)
    {
        switch(type){
            case CAR : return SlotType.MEDIUM;
            case BIKE : return SlotType.COMPACT;
            case TRUCK : return SlotType.LARGE;
            default : return SlotType.COMPACT;
        }
    }

}
