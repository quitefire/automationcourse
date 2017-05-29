package com.courses.homework.ooptest;

import org.junit.Assert;
import org.junit.Test;

public class RunTests {



    @Test
    public void testGetWords1(){
        String[] expected = {"cab", "abc", "cab", "cab", "bac", "bac"};
        String[] actual = TextUtils.getWords("cab; abc; cab; cab; bac; bac");
        Assert.assertArrayEquals(expected, actual);
/*        for (int i=0; i<expected.length; i++) {
            System.out.println(expected[i]);
        }*/
    }

    @Test
    public void testGetWords2(){
        String[] expected = {};
        String[] actual = TextUtils.getWords("");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetWords3(){
        String[] expected = {};
        String[] actual = TextUtils.getWords(null);
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void testGetUniqueWords(){
        String[] expected = {"cab", "abc", "bac"};
        String[] input = {"cab", "abc", "cab", "cab", "bac", "bac"};
        String[] actual = TextUtils.getUniqueWords(input);
        Assert.assertArrayEquals(expected, actual);
//        System.out.println("Expected: "+expected+" Actual: "+actual);
    }

    @Test
    public void testSortWords(){
        String[] expected = {"abc", "bac", "cab"};
        String[] actual = {"cab", "abc", "bac"};
        actual = TextUtils.sortWords(actual);
        Assert.assertArrayEquals(expected, actual);
    }
    @Test
    public void testGetUniqueSortedWords1(){
        String[] expected = {"abc", "bac", "cab"};
        String[] actual = TextUtils.getUniqueSortedWords("cab; abc; cab; cab; bac; bac");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetUniqueSortedWords2(){
        String[] expected = {};
        String[] actual = TextUtils.getUniqueSortedWords(null);
        Assert.assertArrayEquals(expected, actual);
    }

}
