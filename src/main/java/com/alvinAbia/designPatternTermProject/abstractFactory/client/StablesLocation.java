package com.alvinAbia.designPatternTermProject.abstractFactory.client;

import com.alvinAbia.designPatternTermProject.abstractFactory.Cavalry;
import com.alvinAbia.designPatternTermProject.abstractFactory.Unit;
import com.alvinAbia.designPatternTermProject.abstractFactory.factory.HeavyEquipmentFactory;
import com.alvinAbia.designPatternTermProject.abstractFactory.factory.LightEquipmentFactory;
import com.alvinAbia.designPatternTermProject.abstractFactory.factory.UnitEquipmentFactory;

import java.io.IOException;

/**
 * A concrete implementation of {@link UnitProductionLocation} that uses the different {@link UnitEquipmentFactory}
 * implementations to produce sets of equipment for a given {@link Unit type} {@link Cavalry}
 */
public class StablesLocation extends UnitProductionLocation {
  UnitEquipmentFactory heavyFactory = new HeavyEquipmentFactory();
  UnitEquipmentFactory lightFactory = new LightEquipmentFactory();

  @Override
  public Unit createUnit(Unit.EquipmentType type) throws IOException {
    return switch (type) {
      case HEAVY -> new Cavalry(heavyFactory);
      case LIGHT -> new Cavalry(lightFactory);
      default -> throw new IOException("Not implemented yet");
    };
  }
}
