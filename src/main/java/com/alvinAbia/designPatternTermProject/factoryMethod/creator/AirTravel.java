package com.alvinAbia.designPatternTermProject.factoryMethod.creator;

import com.alvinAbia.designPatternTermProject.factoryMethod.product.Dragon;
import com.alvinAbia.designPatternTermProject.factoryMethod.product.Mount;

/**
 * A concrete implementation of the {@link Travel} class that implements {@link #createMount()}} to produce a concrete
 * {@link Mount}
 */
public class AirTravel extends Travel {
  @Override
  Mount createMount() {
    return new Dragon();
  }
}
