package com.denis.kisina.practice.amazon;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.*;

public class LargestItemAssociationTest extends TestCase {

    LargestItemAssociation s = new LargestItemAssociation();
    PairString p = new PairString("", "");

    public void testLargestItemAssociation() {

        List<PairString> input = Arrays.asList(
                new PairString[]{
                        new PairString("item1", "item2"),
                        new PairString("item3", "item4"),
                        new PairString("item4", "item5")
                }
        );
        List<String> output = new ArrayList<>();
        output.add("item3");
        output.add("item4");
        output.add("item5");

        Assert.assertEquals(output, input);

    }
}