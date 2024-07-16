package com.alvinAbia.designPatternTermProject.singleton;

import com.alvinAbia.designPatternTermProject.Scene;

public class LocationVisitScene implements Scene {
  public void begin() {
    System.out.println("Loading in player with health: " + Player.INSTANCE.getHealth());

    Location healer = new HealerLocation();
    healer.visit();
    System.out.println("Player has health: " + Player.INSTANCE.getHealth());

    Location boss = new BossLocation();
    boss.visit();
    System.out.println("Player has health: " + Player.INSTANCE.getHealth());
  }
}
