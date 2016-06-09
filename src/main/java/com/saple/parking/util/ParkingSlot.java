package com.saple.parking.util;

import java.util.concurrent.PriorityBlockingQueue;

public class ParkingSlot {

	private static volatile PriorityBlockingQueue<Integer> queue;

	public static void createParkingSlot(int total) {
		queue = new PriorityBlockingQueue<Integer>();
		for (int len = 1; len <= total; len++)
			queue.add(len);
	}

	public static int getParkingSlot() {
		if (queue.size() > 0)
			return queue.poll();
		return 0;
	}

	public static void freeParkingSlot(int number) {
		if (number > ParkingUtil.totalParkingslot())
			throw new IllegalArgumentException();
		queue.add(number);
	}

}
