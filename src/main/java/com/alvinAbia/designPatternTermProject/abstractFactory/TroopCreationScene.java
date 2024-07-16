package com.alvinAbia.designPatternTermProject.abstractFactory;

import com.alvinAbia.designPatternTermProject.Scene;
import com.alvinAbia.designPatternTermProject.abstractFactory.client.BarracksLocation;
import com.alvinAbia.designPatternTermProject.abstractFactory.client.StablesLocation;
import com.alvinAbia.designPatternTermProject.abstractFactory.client.UnitProductionLocation;

import java.io.IOException;

public class TroopCreationScene implements Scene {
  public void begin() {
    UnitProductionLocation barracks = new BarracksLocation();
    UnitProductionLocation stables = new StablesLocation();

    try {
      Unit templar = barracks.createUnit(Unit.EquipmentType.HEAVY);
      System.out.println("Templar:\n" + templar);

      Unit rogue = barracks.createUnit(Unit.EquipmentType.LIGHT);
      System.out.println("Rogue:\n" + rogue);

      Unit knight = stables.createUnit(Unit.EquipmentType.HEAVY);
      System.out.println("Knight:\n" + knight);

      Unit scout = stables.createUnit(Unit.EquipmentType.LIGHT);
      System.out.println("Scout:\n" + scout);
    } catch (IOException e) {
    }
  }
}
