# Design Patterns W01 S24 Term Project - Alvin Abia

This project will showcase the various design patterns in the Creational category.

## Architecture Design
Our system is a partial implementation of a system to let people play test various concepts in an R&D game concept. 
Since the game is still in ideation phase, we also have the opportunity to test various software design patterns that we 
should leverage as the game matures in its development. We tie a specific design pattern to a specific part of the game 
in isolated `Scenes` in order to decouple the spin up and down of various game ideas based on player feedback while 
researching what design patterns should be leveraged in the final system design.

The game concepts being tested and their implemented design pattern are listed below:
- The [Abstract Factory](src/main/java/com/alvinAbia/designPatternTermProject/abstractFactory/README.md) pattern is used 
to implement the player's ability to produce families of related equipment for their units.
- The [Builder](src/main/java/com/alvinAbia/designPatternTermProject/builder/README.md) pattern is used to implement the 
management of a player's inventory as they progress through the game.
- The [Factory Method](src/main/java/com/alvinAbia/designPatternTermProject/factoryMethod/README.md) pattern is used to 
implement how the player navigates locations throughout the game.
- The [Prototype](src/main/java/com/alvinAbia/designPatternTermProject/prototype/README.md) pattern is used to implement 
how certain units in the game are able to clone themselves during gameplay.
- The [Singleton](src/main/java/com/alvinAbia/designPatternTermProject/singleton/README.md) pattern is used to guarantee 
that the player of the game is only initialized once and can be accessible globally throughout the game logic.

[System Architecture Diagram](https://whimsical.com/system-architecture-RaLbSZbPPYEJyLZD1dLcF3@3CRerdhrAqBtcRbVRgTu6Uwz)

```java
/**
 * Shared interface that all game idea concepts implement in order for the user to access and interact with it.
 */
public interface Scene {
  void begin();
}
```

```java
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
```