package com.alvinAbia.designPatternTermProject.singleton;

/**
 * A concrete {@link Location} that affects the {@link Player} Singleton when {@link #visit()} is called
 */
public class BossLocation implements Location {
  @Override
  public void visit() {
    System.out.println("Player visits the Boss and takes 50 damage!");
    Player.INSTANCE.setHealth(Player.INSTANCE.getHealth() - 50);
  }
}
