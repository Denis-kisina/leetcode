package com.denis.kisina.practice;

import junit.framework.TestCase;
import org.junit.Assert;

public class MergeStringsTest extends TestCase {

    MergeStrings mergeStrings = new MergeStrings();

    public void testMerge() {
        Assert.assertEquals("abcde", mergeStrings.merge("ace", "bd") );
    }
}