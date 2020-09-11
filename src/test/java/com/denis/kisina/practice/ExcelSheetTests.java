package com.denis.kisina.practice;

import org.junit.Assert;
import org.junit.Test;

public class ExcelSheetTests {
    ExcelSheet excelSheet = new ExcelSheet();
    @Test
    public void testZY(){

        int actual = excelSheet.titleToNumber("ZY");
        int expected = 701;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testA(){
        int actual = excelSheet.titleToNumber("A");
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAB(){
        int actual = excelSheet.titleToNumber("AB");
        int expected = 28;
        Assert.assertEquals(expected, actual);
    }
}
