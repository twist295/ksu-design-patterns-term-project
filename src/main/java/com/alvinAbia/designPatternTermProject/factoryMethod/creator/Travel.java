package com.alvinAbia.designPatternTermProject.factoryMethod.creator;

import com.alvinAbia.designPatternTermProject.factoryMethod.Direction;
import com.alvinAbia.designPatternTermProject.factoryMethod.product.Mount;

/**
 * The abstract Creator that contains the factory method {@link #createMount}
 */
public abstract class Travel {
  public void move(Direction direction) {
    Mount mount = createMount();
    mount.move(direction);
  }

  abstract Mount createMount();
}
