package com.saple.parking.util;

public class ParkingUtil {

	private static volatile int totalNumberOfParking;

	public static void createParkingSlot(int num) {
		totalNumberOfParking = num;
		ParkingSlot.createParkingSlot(num);
	}

	public static  int totalParkingslot() {
		if (totalNumberOfParking == 0)
			throw new RuntimeException("First Create parking slot");
		return totalNumberOfParking;
	}

}
