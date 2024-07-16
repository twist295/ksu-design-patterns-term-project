package com.alvinAbia.designPatternTermProject.prototype;

import java.util.Random;

/**
 * {@link Amoeba} is the concrete {@link Cloneable} that implements function to clone. Its data can be used to configure
 * those copies.
 */
public class Amoeba implements Cloneable {
  protected int health = 100;

  @Override
  public Cloneable clone() {
    return new AmoebaClone(health);
  }

  public void attack() {
    Random random = new Random();
    int damage = random.nextInt(7);
    System.out.printf("Amoeba attacks you for %s damage\n", damage);
  }

  public void defend(int damage) {
    health -= damage;
    System.out.printf("Amoeba took %s damage, %s health remaining\n", damage, health);
  }
}
