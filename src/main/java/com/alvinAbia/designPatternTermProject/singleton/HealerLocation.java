package com.alvinAbia.designPatternTermProject.singleton;

public class HealerLocation implements Location {
  @Override
  public void visit () {
    System.out.println("Player visits the Healer and gains 20 HP");
    Player.INSTANCE.setHealth(Player.INSTANCE.getHealth() + 20);
  }
}
