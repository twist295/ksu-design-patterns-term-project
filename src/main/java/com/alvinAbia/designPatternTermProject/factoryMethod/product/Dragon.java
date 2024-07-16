package com.alvinAbia.designPatternTermProject.factoryMethod.product;

import com.alvinAbia.designPatternTermProject.factoryMethod.Direction;

/**
 * A concrete Product produced by a concrete {@link com.alvinAbia.designPatternTermProject.factoryMethod.creator.Travel}
 */
public class Dragon implements Mount {
  @Override
  public void move(Direction direction) {
    System.out.printf("Flying %s", direction.getRaw());
  }
}
