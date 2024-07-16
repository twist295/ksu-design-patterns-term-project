package com.alvinAbia.designPatternTermProject.factoryMethod.product;

import com.alvinAbia.designPatternTermProject.factoryMethod.Direction;

public class Galley implements Mount {
  @Override
  public void move(Direction direction) {
    System.out.printf("Sailing %s", direction.getRaw());
  }
}
