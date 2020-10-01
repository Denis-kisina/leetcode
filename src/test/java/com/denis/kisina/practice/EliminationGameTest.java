package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;

public class EliminationGameTest extends TestCase {

    EliminationGame eliminationGame = new EliminationGame();

    public void testLastRemaining() {
        Assert.assertEquals(6, eliminationGame.lastRemaining(9));
    }
}