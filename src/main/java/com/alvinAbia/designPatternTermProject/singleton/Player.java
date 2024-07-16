package com.alvinAbia.designPatternTermProject.singleton;

/**
 * The Player Singleton that has one instance accessed globally across all game locations.
 */
public enum Player {
  INSTANCE;

  private int health;

  Player() {
    System.out.println("Running super expensive logic for creating a new Player");
    this.health = 100;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }
}
