package com.saple.parking;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.saple.parking.util.ParkingSlot;

public class ParkingSlotTest {

	@Test
	public void parkingSlot1() {
		assertEquals(1, ParkingSlot.getParkingSlot());
	}

	@Test
	public void parkingSlot2() {
		assertEquals(2, ParkingSlot.getParkingSlot());
	}

	@Test
	public void parkingSlot3() {
		assertEquals(1, ParkingSlot.getParkingSlot());
	}
	
	@Test
	public void parkingSlotAddGetTest() {
		ParkingSlot.freeParkingSlot(2);
		assertEquals(2, ParkingSlot.getParkingSlot());
	}
	
	

	@Test
	public void parkingSlotfullParking() {
		ParkingSlot.getParkingSlot();
		ParkingSlot.getParkingSlot();
		ParkingSlot.getParkingSlot();
		ParkingSlot.getParkingSlot();
		ParkingSlot.freeParkingSlot(20);
		ParkingSlot.getParkingSlot();
		ParkingSlot.getParkingSlot();
		ParkingSlot.getParkingSlot();
		assertEquals(2, ParkingSlot.getParkingSlot());
	}

}
