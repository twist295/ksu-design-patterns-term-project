package com.alvinAbia.designPatternTermProject.abstractFactory;

import com.alvinAbia.designPatternTermProject.abstractFactory.product.Armor;
import com.alvinAbia.designPatternTermProject.abstractFactory.product.Weapon;

public abstract class Unit {
  public enum EquipmentType { HEAVY, MEDIUM, LIGHT };

  protected Weapon weapon;

  protected Armor armor;

  @Override
  public String toString() {
    return String.format("""
       - Weapon: %s
       - Armor: %s
        """, weapon, armor);
  }
}
