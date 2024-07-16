package com.alvinAbia.designPatternTermProject.abstractFactory.client;

import com.alvinAbia.designPatternTermProject.abstractFactory.Infantry;
import com.alvinAbia.designPatternTermProject.abstractFactory.Unit;
import com.alvinAbia.designPatternTermProject.abstractFactory.factory.HeavyEquipmentFactory;
import com.alvinAbia.designPatternTermProject.abstractFactory.factory.LightEquipmentFactory;
import com.alvinAbia.designPatternTermProject.abstractFactory.factory.UnitEquipmentFactory;

import java.io.IOException;

public class BarracksLocation extends UnitProductionLocation {
  @Override
  public Unit createUnit(Unit.EquipmentType type) throws IOException {
    UnitEquipmentFactory heavyFactory = new HeavyEquipmentFactory();
    UnitEquipmentFactory lightFactory = new LightEquipmentFactory();

    return switch (type) {
      case HEAVY -> new Infantry(heavyFactory);
      case LIGHT -> new Infantry(lightFactory);
      default -> throw new IOException("Not implemented yet");
    };
  }
}
