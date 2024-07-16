## Abstract Factory

### Description:
The _Abstract Factory_ pattern lets a system produce families of _Products_ that are related without explicitly 
specifying the concrete implementations of those _Products_.

[UML Diagram](https://whimsical.com/abstract-factory-DAL7PbtzvXJbd4s6iUK7Tx@6HYTAunKLgTV1pWMXntMNDLhG3Lgg4SL2cs2QABXfFjDrrY)

### System Usage:
Our system uses this pattern in order to produce sets of equipment for various classes of `Units`. `Cavalry` and 
`Infantry` `Unit` types look and function very different but all have equipment that is modelled as a _Product_ family. 
There are `Heavy` and `Light` equipment those `Unit` types can equip so depending on the used concrete factory of 
`UnitEquipmentFactory`, various clients like `BarracksLocation` or `StablesLocation` can produce those equipment sets 
without needing to depend on concrete implementations of the equipment _Products_.

[Usage in System Diagram](https://whimsical.com/abstract-factory-DAL7PbtzvXJbd4s6iUK7Tx@or4CdLRbgiwYVCxkSpHNjRQAhnYeBwbJ61gos4H7i)

### Source Code:
```java
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
```

```java
/**
 * Abstract factory for producing sets of equipment.
 */
public interface UnitEquipmentFactory {
  Armor createArmor();

  Weapon createWeapon();
}
```

```java
/**
 * Concrete implementation of the {@link UnitEquipmentFactory} abstract factory that produces a concrete family of
 * equipment Products.
 */
public class LightEquipmentFactory implements UnitEquipmentFactory {
  @Override
  public Armor createArmor() {
    return new LeatherArmor();
  }

  @Override
  public Weapon createWeapon() {
    return new Dagger();
  }
}
```

```java
/**
 * Abstract client class that is implemented to produce various types of {@link Unit}
 */
public abstract class UnitProductionLocation {
  public abstract Unit createUnit(Unit.EquipmentType type) throws IOException;
}
```

```java
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
```

### Consequences:
#### Pros:
- Ensures concrete implementations of specific _Products_ are interchangeable since they share the same interface that 
is produced by the _Abstract Factory_.
- Concrete _Product_ implementations are decoupled from client logic.
- Adheres to _Single Responsibility Principle_ as the production of _Products_ are encapsulated into one place.
- Client logic can be extended to new _Product_ variations while remaining closed to modification of existing client 
code.

#### Cons:
- Can lead to more complex code since a lot of new interfaces and classes need to be introduced. 