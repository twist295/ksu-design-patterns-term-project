package com.alvinAbia.designPatternTermProject.abstractFactory;

import com.alvinAbia.designPatternTermProject.abstractFactory.factory.UnitEquipmentFactory;

public class Infantry extends Unit {
  public Infantry(UnitEquipmentFactory equipmentFactory) {
    armor = equipmentFactory.createArmor();
    weapon = equipmentFactory.createWeapon();
  }

  @Override
  public String toString() {
    return String.format("""
       - Type: Infantry
       %s
        """, super.toString());
  }
}
