## Factory Method

### Description:
The Factory Method pattern is where a superclass provides an interface for object creation that lets subclasses choose 
the type of the created object. The _Creator_ is that superclass that provides an abstract method that its concrete 
subclasses implement in order to produce a concrete _Product_. The _Creator_ has no knowledge of what kind of concrete 
_Product_ it is using in its own operation, just that it matches an interface it expects. This effectively decouples 
_Creator_ business logic from any concrete implementations of _Product_ as it relies on that _Product_ interface as an 
abstraction.

This is the [UML Diagram](https://whimsical.com/factorymethod-6KAZh8eAUeoq47JLP7V4G6@or4CdLRbgroPPKnu3uRURDXBXm8RNshRoxNFLQcLu)
for this pattern.


### System Usage:
Our game leverages the Factory Method pattern in order to model how a player navigates through the game.

The abstract `Travel` class serves as the Creator. It contains the factory method `createMount` that concrete Creators 
implement in order to produce a concrete `Mount` Product. The implementation of that concrete `Mount` instance's `move`
method is what will be invoked whenever the player chooses a direction to move (modelled as invocations of 
`Travel.move`).

This is the [UML Diagram](https://whimsical.com/factorymethod-6KAZh8eAUeoq47JLP7V4G6@or4CdLRbgroPPKnu3uRURDXBXm8RNshRoxNFLQcLu) 
for how this pattern is used in this system. 

### Source Code
```java
/**
 * The abstract Product from which concrete instances are produced by concrete Creators for use in their abstract
 * superclass.
 */
public interface Mount {
  void move(Direction direction);
}
```

```java
/**
 * A concrete Product produced by a concrete {@link com.alvinAbia.designPatternTermProject.factoryMethod.creator.Travel}
 */
public class Dragon implements Mount {
  @Override
  public void move(Direction direction) {
    System.out.printf("Flying %s", direction.getRaw());
  }
}
```

```java
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
```

```java
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
```

### Consequences:
#### Pros:
- Adheres to the concept of writing code that is open for extension while closed for modification. New products can be 
introduced in a way that doesn't require updating existing client code.
- Adheres to the _Single Responsibility Principle_ in that it encapsulates Product creation logic into one place.
- Creators are written against abstractions instead of implementations in that they are decoupled from concrete 
Products.

#### Cons:
- Can lead to a more complex codebase as new subclasses are required to represent additional concrete Product and 
Creator.