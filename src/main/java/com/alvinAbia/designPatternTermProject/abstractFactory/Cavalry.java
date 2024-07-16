package com.alvinAbia.designPatternTermProject.abstractFactory;

import com.alvinAbia.designPatternTermProject.abstractFactory.factory.UnitEquipmentFactory;

/**
 * A concrete class that is instantiated with a given concrete implementation of {@link UnitEquipmentFactory} so that a
 * set of equipment is produced without the client needing to interact with concrete implementations of those products.
 */
public class Cavalry extends Unit {
  public Cavalry(UnitEquipmentFactory equipmentFactory) {
    armor = equipmentFactory.createArmor();
    weapon = equipmentFactory.createWeapon();
  }

  @Override
  public String toString() {
    return String.format("""
       - Type: Cavalry
       %s
        """, super.toString());
  }
}
