package com.alvinAbia.designPatternTermProject.abstractFactory.factory;

import com.alvinAbia.designPatternTermProject.abstractFactory.product.Armor;
import com.alvinAbia.designPatternTermProject.abstractFactory.product.Flail;
import com.alvinAbia.designPatternTermProject.abstractFactory.product.PlateMail;
import com.alvinAbia.designPatternTermProject.abstractFactory.product.Weapon;

public class HeavyEquipmentFactory implements UnitEquipmentFactory {
  @Override
  public Armor createArmor() {
    return new PlateMail();
  }

  @Override
  public Weapon createWeapon() {
    return new Flail();
  }
}
