package com.alvinAbia.designPatternTermProject.factoryMethod;

import com.alvinAbia.designPatternTermProject.Scene;
import com.alvinAbia.designPatternTermProject.factoryMethod.creator.AirTravel;
import com.alvinAbia.designPatternTermProject.factoryMethod.creator.Travel;
import com.alvinAbia.designPatternTermProject.factoryMethod.creator.WaterTravel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MapTravelScene implements Scene {
	public void begin() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Pick how you want to travel: (air, water, land)");

		Travel travelMode;

		int turnsUntilEncounter = 5;

		try {
			String mode = reader.readLine();

      travelMode = switch (mode) {
        case "air" -> new AirTravel();
        case "water" -> new WaterTravel();
        default -> throw new IOException("unrecognized command");
      };

			do {
				System.out.println("\nPick a direction: (w,a,s,d)");
				String directionKey = reader.readLine();

				switch (directionKey) {
					case "w":
						travelMode.move(Direction.NORTH);
						break;
					case "a":
						travelMode.move(Direction.WEST);
						break;
					case "s":
						travelMode.move(Direction.SOUTH);
						break;
					case "d":
						travelMode.move(Direction.EAST);
				}
				turnsUntilEncounter--;
			} while (turnsUntilEncounter > 0);

			System.out.println("\nBATTLE ENCOUNTER WITH AMOEBA");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
