package com.saple.parking;

public class ParkingTicket {

	private Car car;
	private int slotNumber;

	private ParkingTicket(Builder builder) {
		this.car = builder.car;
		this.slotNumber = builder.slotNumber;
	}

	public Car getCar() {
		return car;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private Car car;
		private int slotNumber;

		public Builder car(Car car) {
			this.car = car;
			return this;
		}

		public Builder slotNumber(int slotNumber) {
			this.slotNumber = slotNumber;
			return this;
		}

		public ParkingTicket build() {
			if (car == null || slotNumber <= 0)
				throw new IllegalArgumentException();
			ParkingTicket parkingTicket = new ParkingTicket(this);
			return parkingTicket;
		}
	}

}
