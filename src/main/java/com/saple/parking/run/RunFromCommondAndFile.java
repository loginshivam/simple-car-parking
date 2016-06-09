package com.saple.parking.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.saple.parking.Car;
import com.saple.parking.ParkingTicket;
import com.saple.parking.util.CarParking;
import com.saple.parking.util.ParkingSlot;
import com.saple.parking.util.ParkingUtil;

public class RunFromCommondAndFile {

	public static void runCommond() {
		while (true) {
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(System.in));
				commonParser(bufferedReader.readLine());
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}

	public static void runFromFile(String fileName) {

		File file = new File(fileName);
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String lineFromFile = "";
			try {
				while ((lineFromFile = bufferedReader.readLine()) != null) {
                     commonParser(lineFromFile);
				}
			} catch (IOException e) {

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static void commonParser(String input) {
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

	private static void createParking(String[] input) {
		ParkingUtil.createParkingSlot(Integer.parseInt(input[1]));
		System.out
				.println("Created a parking lot with " + input[1] + "  slots");
	}

	private static void park(String[] input) {
		Car car = Car.builder().registrationNumber(input[1]).color(input[2])
				.build();
		int num = ParkingSlot.getParkingSlot();
		if (num == 0)
			System.out.println("Sorry, parking lot is full");
		else {
			ParkingTicket parkingTicket = ParkingTicket.builder().car(car)
					.slotNumber(num).build();
			CarParking.addCarToParking(parkingTicket);
			System.out.println("Allocated slot number: " + num);
		}
	}

	private static void regNumbersByColor(String[] input) {
		List<String> list = CarParking.registrationNumberByCarColor(input[1]);
		if (list != null) {
			for (String str : list) {
				System.out.println(str);
			}
		}

	}

	private static void slotNumbersByColor(String[] input) {

		System.out.println(CarParking.parkingSlotsByCarColor((input[1])));
	}

	private static void slotNumberByRegistrationNumber(String[] input) {
		Integer slot = CarParking.slotNumberByRegistrationNumber(input[1]);
		if (slot == 0)
			System.out.println("Not found");
		else
			System.out.println(slot);

	}

	private static void leaveCarFromParking(String[] input) {
		CarParking.removeCarFromParking(Integer.parseInt(input[1]));
		System.out.println("Slot number " + input[1] + " is free");
	}

	private static void parkingStatus(String[] input) {
		List<ParkingTicket> list = CarParking.parkingStatus();
		if (list != null && list.size() > 0) {
			System.out.println("Slot No.  Registration No     Colour");
			System.out.println("------------------------------------");
			for (ParkingTicket parkingTicket : list) {
				System.out.print(parkingTicket.getSlotNumber() + "         ");
				System.out.print(parkingTicket.getCar().getRegistrationNumber()
						+ "          ");
				System.out
						.print(parkingTicket.getCar().getColor() + "        ");
				System.out.println();
				System.out.println("------------------------------------");
			}
		}
	}
}
