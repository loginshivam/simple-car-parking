package com.saple.parking.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.saple.parking.Car;
import com.saple.parking.ParkingTicket;

public class CarParking {

	private static volatile ConcurrentHashMap<Integer, Car> carParking;

	static {
		carParking = new ConcurrentHashMap<Integer, Car>();
	}

	public static void addCarToParking(ParkingTicket parkingTicket) {
		carParking.put(parkingTicket.getSlotNumber(), parkingTicket.getCar());
	}

	public static void removeCarFromParking(int parkingSlot) {
		carParking.remove(parkingSlot);
		ParkingSlot.freeParkingSlot(parkingSlot);
	}

	public static List<String> registrationNumberByCarColor(String color) {
		List<String> registrationNumber = new ArrayList<String>();
		for (int number : carParking.keySet()) {
			Car car = carParking.get(number);
			if (car.getColor().equalsIgnoreCase(color))
				registrationNumber.add(car.getRegistrationNumber());
		}
		return registrationNumber;
	}

	public static Integer slotNumberByRegistrationNumber(
			String registrationNumber) {
		Integer slotNum = 0;
		for (Integer number : carParking.keySet()) {
			Car car = carParking.get(number);
			if (car.getRegistrationNumber()
					.equalsIgnoreCase(registrationNumber)) {
				slotNum = number;
				break;
			}

		}
		return slotNum;
	}

	public static List<Integer> parkingSlotsByCarColor(String color) {
		List<Integer> parkingSlot = new ArrayList<Integer>();
		for (int number : carParking.keySet()) {
			Car car = carParking.get(number);
			if (car.getColor().equalsIgnoreCase(color))
				parkingSlot.add(number);
		}
		return parkingSlot;
	}

	public static List<ParkingTicket> parkingStatus() {
		List<ParkingTicket> parkingTickets = new ArrayList<ParkingTicket>();
		for (Integer num : carParking.keySet()) {
			ParkingTicket parkingTicket = ParkingTicket.builder()
					.slotNumber(num).car(carParking.get(num)).build();
			parkingTickets.add(parkingTicket);
		}
		return parkingTickets;
	}

}
