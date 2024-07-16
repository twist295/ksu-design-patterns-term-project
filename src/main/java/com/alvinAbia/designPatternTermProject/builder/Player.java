package com.alvinAbia.designPatternTermProject.builder;

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
