## Singleton

### Description:
The _Singleton_ pattern lets a class ensure that it has only one instance with a way to access it globally.

[UML Diagram](https://whimsical.com/singleton-AxoMNrD5SWWCfDkNfVbW7R@5QtYEQ3Nz4jB8jgGA)

### System Usage:
Our game is single player so this pattern is used to ensure that there is only one `Player` instance. Let's assume that 
once the game is fully implemented, creating that `Player` instance is a very expensive operation, so we don't want to 
accidentally do so more than once. We also have `Locations` which are places that the `Player` can visit for an effect.
Because `Player` is a singleton instance, we are able to globally access it from each concrete `Location` without 
passing it in as a parameter.

[Usage in System Diagram](https://whimsical.com/singleton-AxoMNrD5SWWCfDkNfVbW7R@or4CdLRbgivruhMFmrdtGV4V8xHusX94qB2UJYZS8)

### Source Code
```java
/**
 * The Player Singleton that has one instance accessed globally across all game locations.
 */
public enum Player {
  INSTANCE;

  private int health;

  Player() {
    System.out.println("Running super expensive logic for creating a new Player");
    this.health = 100;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }
}
```

```java
/**
 * A concrete {@link Location} that affects the {@link Player} Singleton when {@link #visit()} is called
 */
public class BossLocation implements Location {
  @Override
  public void visit() {
    System.out.println("Player visits the Boss and takes 50 damage!");
    Player.INSTANCE.setHealth(Player.INSTANCE.getHealth() - 50);
  }
}

```

### Consequences:
#### Pros:
- Ensures that a class has only one instance and has a way for it to be globally accessible.
- If instantiation of the _Singleton_ instance is expensive, it can be done lazily, so it only runs when it's initially 
requested.

#### Cons:
- Can lead to unintended performance/duplication issues in multithreaded systems if not handled appropriately.
- Can be difficult to test logic that depends on a _Singleton_ instance because they are not conducive for mocking (they 
have private constructors which prevent inheritance-based mocking and most languages do not support overriding static instance getters).
- Can lead to bad design as it can encourage system components to be tightly coupled to each other.