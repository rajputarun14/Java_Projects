public class Main {
    public static void main(String[] args) {
        {
            try
            {
                ParkingLot lot = new ParkingLot();
                ParkingFloor floor = new ParkingFloor(1);

                /*ParkingSlot slot1= new ParkingSlot("1-1", SlotType.COMPACT);
                ParkingSlot slot2= new ParkingSlot("1-2", SlotType.LARGE);
                ParkingSlot slot3= new ParkingSlot("1-3", SlotType.COMPACT);
                ParkingSlot slot4= new ParkingSlot("1-3", SlotType.MEDIUM);*/

                floor.addSlot(new ParkingSlot("1-1", SlotType.COMPACT));
                floor.addSlot(new ParkingSlot("1-2", SlotType.LARGE));
                floor.addSlot(new ParkingSlot("1-3", SlotType.COMPACT));
                floor.addSlot(new ParkingSlot("1-3", SlotType.MEDIUM));

                lot.addFloor(floor);

                Vehicle car = new Vehicle("car_123", VehicleType.BIKE);

                Ticket ticket = lot.parkVehicle(car);

                lot.unparkVehicle(ticket.getTicketId());
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
