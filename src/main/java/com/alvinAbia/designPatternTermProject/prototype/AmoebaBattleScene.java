package com.alvinAbia.designPatternTermProject.prototype;

import com.alvinAbia.designPatternTermProject.Scene;

import java.util.Random;

public class AmoebaBattleScene implements Scene {
  public void begin() {
    System.out.println("You are fighting an Amoeba, legends tell of its ability to clone itself");
    Amoeba amoeba = new Amoeba();

    Random random = new Random();
    int damage = random.nextInt(11);
    amoeba.defend(damage);

    System.out.println("Amoeba responds by cloning itself...");
    Amoeba amoebaClone = (Amoeba) amoeba.clone();

    amoebaClone.attack();
    System.out.printf("Which Amoeba do you attack next: (A1:%s/100, A2:%s/100)", amoeba.health, amoebaClone.health);
  }
}
