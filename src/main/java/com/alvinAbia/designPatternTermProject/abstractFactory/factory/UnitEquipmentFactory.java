package com.alvinAbia.designPatternTermProject.abstractFactory.factory;

import com.alvinAbia.designPatternTermProject.abstractFactory.product.Armor;
import com.alvinAbia.designPatternTermProject.abstractFactory.product.Weapon;

/**
 * Abstract factory for producing sets of equipment.
 */
public interface UnitEquipmentFactory {
  Armor createArmor();

  Weapon createWeapon();
}
