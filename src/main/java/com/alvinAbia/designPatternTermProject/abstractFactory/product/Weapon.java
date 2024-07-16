package com.alvinAbia.designPatternTermProject.abstractFactory.product;

/**
 * {@link Weapon} is an abstract Product whose subclasses are produced by concrete implementations of the abstract
 * factory {@link com.alvinAbia.designPatternTermProject.abstractFactory.factory.UnitEquipmentFactory}
 */
public abstract class Weapon {
  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}
