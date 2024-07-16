package com.alvinAbia.designPatternTermProject.abstractFactory.client;

import com.alvinAbia.designPatternTermProject.abstractFactory.Unit;

import java.io.IOException;

/**
 * Abstract client class that is implemented to produce various types of {@link Unit}
 */
public abstract class UnitProductionLocation {
  public abstract Unit createUnit(Unit.EquipmentType type) throws IOException;
}
