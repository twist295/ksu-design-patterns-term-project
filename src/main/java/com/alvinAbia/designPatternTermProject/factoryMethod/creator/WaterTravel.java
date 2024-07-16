package com.alvinAbia.designPatternTermProject.factoryMethod.creator;

import com.alvinAbia.designPatternTermProject.factoryMethod.product.Galley;
import com.alvinAbia.designPatternTermProject.factoryMethod.product.Mount;

public class WaterTravel extends Travel {
  @Override
  Mount createMount() {
    return new Galley();
  }
}
