import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSlot> parkingSlot ; 

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSlot = new ArrayList<>();
    }
    public int getFloorNumber() {
        return floorNumber;
    }
    public List<ParkingSlot> getParkingSlots() {
        return parkingSlot;
    }
    public void addSlot(ParkingSlot slot)
    {
        slot.setParkingFloor(floorNumber);
        parkingSlot.add(slot);
    }
    public ParkingSlot findAvailableSlot(SlotType slotType)
    {
        for(ParkingSlot slot : parkingSlot)
        {
            if(slotType == slot.getSlotType() && slot.isFree()){
                return slot;
            }
        }
        return null;
    }
}
