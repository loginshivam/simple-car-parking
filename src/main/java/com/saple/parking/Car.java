package com.saple.parking;

public class Car {

	private String color;
	private String registrationNumber;

	public Car(Builder builder) {
		this.color = builder.color;
		this.registrationNumber = builder.registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String color;
		private String registrationNumber;

		public Builder color(String color) {
			this.color = color;
			return this;
		}

		public Builder registrationNumber(String registrationNumber) {
			this.registrationNumber = registrationNumber;
			return this;
		}

		public Car build() {
			if (color == null || registrationNumber == null)
				throw new IllegalArgumentException();
			Car car = new Car(this);
			return car;
		}
	}

}
