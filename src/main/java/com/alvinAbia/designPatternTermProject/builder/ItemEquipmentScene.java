package com.alvinAbia.designPatternTermProject.builder;

import com.alvinAbia.designPatternTermProject.Scene;

/**
 * Leverages the Builder pattern through using the {@link Player.Builder} class to construct a
 * {@link Player} without bloating its constructor. As the {@link Player} progresses through events, various items can
 * be equipped and unequipped to represent the various equipment the player has on. Note how it is open to extension and
 * closed to modification in that new equipment types will not break existing {@link Player} client code and will simply
 * require exposing a new builder method to hook into new types.
 */
public class ItemEquipmentScene implements Scene {
  public void begin() {
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
