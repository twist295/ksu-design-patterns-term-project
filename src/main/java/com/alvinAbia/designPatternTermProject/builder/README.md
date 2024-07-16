## Builder

### Description:
This pattern lets objects be constructed in a step-wise fashion, allowing for various objects of a given class to be 
represented differently using the same construction logic.

[UML Diagram](https://whimsical.com/builder-5dcrP6REwq1ejF4rECrYSM@FNpptVQ16FidyXaBsyHMgJUbDz7rJ)

### System Usage:
This system leverages the _Builder_ pattern to manage a `Player's` equipped items. There is no public constructor for 
the `Player` class and are created through its `Player.Buider` inner static class. Methods on that builder will 
configure a particular representation of a player's equipment. I.e., starting with no equipment, equipping individual 
pieces, preset configurations like "HeavyArmorCombination", etc.

[UML Diagram](https://whimsical.com/builder-5dcrP6REwq1ejF4rECrYSM@FNpptVQ16H5K3mqH4U8KMiUYBrc6v)


### Source Code
```java
/**
 * {@link Player} is a Product that has a private constructor and its only method for creation is through its inner
 * static class {@link Player.Builder}
 */
public class Player {
  private Helmet helmet;

  private Boots boots;

  private Player() {}

  Builder toBuilder() {
    return new Player.Builder()
        .setHelmet(helmet)
        .setBoots(boots);
  }

  @Override
  public String toString() {
    return String.format("""
        \nPlayer Inventory:
        - Helmet: %s
        - Boots: %s
        """, helmet, boots);
  }

  /**
   * {@link Player.Builder} is the Builder implementation that facilitates producing {@link Player} Products in various
   * ways. This allows the system to construct players in however many steps as needed without exposing constructors
   * that need to modified whenever the {@link Player} model is extended. I.e. a new inventory slot can be added,
   * existing player instantiation doesn't break, and an extra step is added in the Builder flow to hook into that new
   * slot.
   */
  static class Builder {
    Helmet helmet;

    Boots boots;

    Builder unequipAll() {
      helmet = null;
      boots = null;
      return this;
    }

    Builder setHelmet(Helmet helmet) {
      this.helmet = helmet;
      return this;
    }

    Builder setBoots(Boots boots) {
      this.boots = boots;
      return this;
    }

    Player build() {
      Player player = new Player();
      player.helmet = helmet;
      player.boots = boots;
      return player;
    }
  }
}
```

```java
/**
 * This {@link Scene} leverages the Builder pattern through using the {@link Player.Builder} class to construct a
 * {@link Player} without bloating its constructor. As the {@link Player} progresses through events, various items can
 * be equipped and unequipped to represent the various equipment the player has on. Note how it is open to extension and
 * closed to modification in that new equipment types will not break existing {@link Player} client code and will simply
 * require exposing a new builder method to hook into new types.
 */
public class Scene {
  public static void main(String[] args) {
    Player player = new Player.Builder().build();
    System.out.println("The Amoeba dropped the skull cap of a fallen adventurer, equipping...");
    player = player.toBuilder()
        .setHelmet(new SkullCap())
        .build();

    System.out.println("Before you leave the battle site, you find a pair of winter boots, equipping...");
    player = player.toBuilder()
        .setBoots(new WinterBoots())
        .build();

    System.out.println(player);

    System.out.println("You return to town after the fight and decide to bathe, unequipped gear...");
    player = player.toBuilder()
        .unequipAll()
        .build();

    System.out.println(player);
  }
}
```

### Consequences:
#### Pros:
- Construction logic can be reused in order to build _Product_ instances in various ways.
- Adheres to the _Single Responsibility Principle_ in that the construction of _Products_ is isolated from its business 
logic.

#### Cons:
- Can lead to more complex code as new classes need to be introduced as _Product_ builders and potentially also classes 
to direct building in specific configurations.