package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Test;

public class DetectCapitalUseTest extends TestCase {

    DetectCapitalUse detectCapitalUse = new DetectCapitalUse();

    @Test
    public void testDetectCapitalUse() {
        assertEquals(detectCapitalUse.detectCapitalUse("USA"), true);
    }

    @Test
    public void test2(){
        assertEquals(detectCapitalUse.detectCapitalUse("FlaG"), false);
    }

    @Test
    public void test3(){
        assertEquals(detectCapitalUse.detectCapitalUse("ggg"), true);
    }
}