package com.saple.parking.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.saple.parking.Car;
import com.saple.parking.ParkingTicket;
import com.saple.parking.util.CarParking;
import com.saple.parking.util.ParkingSlot;
import com.saple.parking.util.ParkingUtil;

public class Commond {

	public static void runCommond() throws IOException {
		while (true) {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(System.in));
			commonParser(bufferedReader.readLine());
		}
	}

	public static void commonParser(String input) {
		if (input == null)
			throw new RuntimeException("Please provide correct input");
		String inputes[] = input.split("\\s");
		String commond = inputes[0];
		if ("create_parking_lot".equalsIgnoreCase(commond)) {
			createParking(inputes);
		} else if ("park".equalsIgnoreCase(commond)) {
			park(inputes);
		} else if ("registration_numbers_for_cars_with_colour"
				.equalsIgnoreCase(commond)) {
			regNumbersByColor(inputes);
		} else if ("slot_numbers_for_cars_with_colour"
				.equalsIgnoreCase(inputes[0])) {
			slotNumbersByColor(inputes);
		} else if ("slot_number_for_registration_number"
				.equalsIgnoreCase(commond)) {
			slotNumberByRegistrationNumber(inputes);
		} else if ("leave".equalsIgnoreCase(commond)) {
			leaveCarFromParking(inputes);
		} else if ("status".equalsIgnoreCase(commond)) {
			parkingStatus(inputes);
		}
	}

	public static void createParking(String[] input) {
		ParkingUtil.createParkingSlot(Integer.parseInt(input[1]));
		System.out
				.println("Created a parking lot with " + input[1] + "  slots");
	}

	public static void park(String[] input) {
		Car car = Car.builder().registrationNumber(input[1]).color(input[2])
				.build();
		int num = ParkingSlot.getParkingSlot();
		if (num == 0)
			System.out.println("Sorry, parking lot is full");
		else {
			ParkingTicket parkingTicket = ParkingTicket.builder().car(car)
					.slotNumber(num).build();
			CarParking.addCarToParking(parkingTicket);
		}
	}

	public static void regNumbersByColor(String[] input) {
		System.out.println(CarParking.registrationNumberByCarColor(input[1]));
	}

	public static void slotNumbersByColor(String[] input) {
		System.out.println(CarParking
				.slotNumberByRegistrationNumber((input[1])));
	}

	public static void slotNumberByRegistrationNumber(String[] input) {
		Integer slot = CarParking.slotNumberByRegistrationNumber(input[1]);
		if (slot == null)
			System.out.println("Not found");
		else
			System.out.println(slot);

	}

	public static void leaveCarFromParking(String[] input) {
		CarParking.removeCarFromParking(Integer.parseInt(input[1]));
		System.out.println("Slot number" + input[1] + " is free");
	}

	public static void parkingStatus(String[] input) {
		CarParking.parkingStatus();// TODO:
	}
}
