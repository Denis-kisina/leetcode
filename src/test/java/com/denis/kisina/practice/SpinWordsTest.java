package com.denis.kisina.practice;

import junit.framework.TestCase;

public class SpinWordsTest extends TestCase {

//    @Test
    public void test() {
        assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
    }
}