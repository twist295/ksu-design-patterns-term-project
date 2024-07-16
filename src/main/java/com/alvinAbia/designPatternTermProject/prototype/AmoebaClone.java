package com.alvinAbia.designPatternTermProject.prototype;

/**
 * This class extends {@link Amoeba} and is created during that super class's cloning process. These clones are
 * initialized with the cloning instance's health and also override the {@link #attack()} method to apply a side effect
 * in addition to its super's implementation.
 */
public class AmoebaClone extends Amoeba {
  public AmoebaClone(int health) {
    this.health = health;
  }

  @Override
  public void attack() {
    super.attack();
    health -= 5;
    System.out.printf("Amoeba takes decay damage from being a clone, %s health remaining\n", health);
  }
}
