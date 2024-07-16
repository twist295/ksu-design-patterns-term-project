package com.alvinAbia.designPatternTermProject;

import com.alvinAbia.designPatternTermProject.abstractFactory.TroopCreationScene;
import com.alvinAbia.designPatternTermProject.builder.ItemEquipmentScene;
import com.alvinAbia.designPatternTermProject.factoryMethod.MapTravelScene;
import com.alvinAbia.designPatternTermProject.prototype.AmoebaBattleScene;
import com.alvinAbia.designPatternTermProject.singleton.LocationVisitScene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Entry point of application, where user selects which {@link Scene} they want to play with.
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Which scene would you like to enter:");
    System.out.println("1: Creating Troops");
    System.out.println("2: Equipping Items");
    System.out.println("3: World Map Traveling");
    System.out.println("4: Amoeba Battle");
    System.out.println("5: Visiting Locations");

    String choice = reader.readLine();
    Scene scene = switch (choice) {
      case "1" -> new TroopCreationScene();
      case "2" -> new ItemEquipmentScene();
      case "3" -> new MapTravelScene();
      case "4" -> new AmoebaBattleScene();
      case "5" -> new LocationVisitScene();
      default -> throw new IOException("unrecognized");
    };

    scene.begin();
  }
}
