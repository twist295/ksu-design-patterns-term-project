## Prototype

### Description:
The _Prototype_ pattern enables the copying of objects without having client code be dependent on those object classes.

[UML Diagram](https://whimsical.com/prototype-6zX5biqh3Yu4vCn7gUx7dy@or4CdLRbgroABmze3vaH1zpkWosoeRsTuRn7YYu8i)

### System Usage:
The system leverages the _Prototype_ pattern to implement a unit ability to clone itself during gameplay. Our game has 
an enemy `Amoeba` that clones itself to make `AmoebaClones`. Those clones take on that unit's health at that point in 
time and take damage on action. From the perspective of client code, these clones are the same class as `Amoeba` despite 
its unique side effects. 

[System Usage Diagram](https://whimsical.com/prototype-6zX5biqh3Yu4vCn7gUx7dy@8ADn3nfZACaTUUnb78zHqcWgkLvjtAjjEkmk)

### Source Code:
```java
/**
 * This interface declares the {@link #clone()} method its implementors will use to make copies.
 */
public interface Cloneable {
  Cloneable clone();
}
```

```java
/**
 * {@link Amoeba} is the concrete {@link Cloneable} that implements function to clone. Its data can be used to configure
 * those copies.
 */
public class Amoeba implements Cloneable {
  protected int health = 100;

  @Override
  public Cloneable clone() {
    return new AmoebaClone(health);
  }

  public void attack() {
    Random random = new Random();
    int damage = random.nextInt(7);
    System.out.printf("Amoeba attacks you for %s damage\n", damage);
  }

  public void defend(int damage) {
    health -= damage;
    System.out.printf("Amoeba took %s damage, %s health remaining\n", damage, health);
  }
}
```
```java
/**
 * This class extends {@link Amoeba} and is created during that super class's cloning process. These clones are
 * initialized with the cloning instance's health and also override the {@link #attack()} method to apply a side effect
 * in addition to its super's implementation.
 */
public class AmoebaClone extends Amoeba {
  public AmoebaClone(int health) {
    this.health = health;
  }

  @Override
  public void attack() {
    super.attack();
    health -= 5;
    System.out.printf("Amoeba takes decay damage from being a clone, %s health remaining\n", health);
  }
}
```

### Consequences:
#### Pros:
- Objects can be cloned without being coupled to concrete implementations.
- Duplicate initialization logic can be refactored into preset prototype configuration.
- Complex objects be produced more efficiently.

#### Cons:
- Cloning objects with cyclic references can be complex to implement.