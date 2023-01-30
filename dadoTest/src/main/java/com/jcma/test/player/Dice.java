package com.jcma.test.player;

import java.util.Random;

public class Dice {

    private int sides;

    public Dice(int sides){
        this.sides = sides;
    }

    public int roll(){
        return new Random().nextInt(this.sides + 1);
    }

}
