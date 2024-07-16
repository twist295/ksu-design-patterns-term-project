package com.alvinAbia.designPatternTermProject.abstractFactory.factory;

import com.alvinAbia.designPatternTermProject.abstractFactory.product.Armor;
import com.alvinAbia.designPatternTermProject.abstractFactory.product.Dagger;
import com.alvinAbia.designPatternTermProject.abstractFactory.product.LeatherArmor;
import com.alvinAbia.designPatternTermProject.abstractFactory.product.Weapon;

/**
 * Concrete implementation of the {@link UnitEquipmentFactory} abstract factory that produces a concrete family of
 * equipment Products.
 */
public class LightEquipmentFactory implements UnitEquipmentFactory {
  @Override
  public Armor createArmor() {
    return new LeatherArmor();
  }

  @Override
  public Weapon createWeapon() {
    return new Dagger();
  }
}
