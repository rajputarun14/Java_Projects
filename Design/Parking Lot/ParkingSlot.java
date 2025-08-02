public class ParkingSlot {
    private String slotId;
    private boolean isFree;
    private SlotType slotType;
    private int parkingFloor;

    public ParkingSlot(String slotId, SlotType slotType) {
        this.slotId = slotId;
        this.isFree = true; // Initially, the slot is free
        this.slotType = slotType;
    }

    public String getSlotId() {
        return slotId;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public SlotType getSlotType() {
        return slotType;
    }
    public void occupySlot()
    {
        isFree = false;
    }
    public void vacantSlot(){
        isFree = true;
    }
    public int getParkingFloor() {
        return parkingFloor;
    }
    public void setParkingFloor(int floorNumber)
    {
        this.parkingFloor = floorNumber;
    }
}
