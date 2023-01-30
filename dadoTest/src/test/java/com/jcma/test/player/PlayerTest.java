package com.jcma.test.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void looses_when_dice_number_is_too_low(){
        // Mockeando la clase Dice
        Dice dice = Mockito.mock(Dice.class);

        // Simulando un valor de Dice
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 5);
        assertEquals(false, player.play());
    }

    @Test
    public void wins_when_dice_number_is_big(){
        // Mockiando la clase Dice
        Dice dice = Mockito.mock(Dice.class);

        // Simulando un valor de Dice
        Mockito.when(dice.roll()).thenReturn(6);

        Player player = new Player(dice, 5);
        assertEquals(true, player.play());
    }

}