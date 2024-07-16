package com.alvinAbia.designPatternTermProject.factoryMethod.product;

import com.alvinAbia.designPatternTermProject.factoryMethod.Direction;

/**
 * The abstract Product from which concrete instances are produced by concrete Creators for use in their abstract
 * superclass.
 */
public interface Mount {
  void move(Direction direction);
}
