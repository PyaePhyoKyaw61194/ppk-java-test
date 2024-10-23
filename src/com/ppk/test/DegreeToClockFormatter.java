package com.ppk.test;

public class DegreeToClockFormatter {
	int minAngle = 0, maxAngle = 360, maxHour = 12;

	public String process(int angle) {
		if (angle < minAngle || angle > maxAngle) {
			throw new IllegalArgumentException("Angle must be between " + minAngle + " and " + maxAngle);
		}

		double degInOneHour = maxAngle / maxHour;
		double degInOneMin = degInOneHour / 60;

		int hour = (int) ((angle / degInOneHour) % maxHour); // Calculate the hour part
		int min = (int) ((angle % degInOneHour) / degInOneMin);

		if (angle == maxAngle)
			hour = maxHour;

		return String.format("Output Time=%02d:%02d", hour, min);

	}

	public static void main(String[] args) {
		DegreeToClockFormatter converter = new DegreeToClockFormatter();

		// Array of angles to process
		int[] angles = { 0, 360, 90, 45, 250 };

		// Loop through each angle and print the result
		for (int angle : angles) {
			try {
				System.out.println("Input angle = " + angle + " => " + converter.process(angle));

			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}
