package eu.joajar.aoc2023.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution01Test {
    @Test
    public void firstPartOfSolution01Test() {
        assertEquals("142", new Solution01("src/test/resources/Input011.txt").solveFirstPart());
    }

    @Test
    public void firstPartOfSolution01WithFinalDataTest() {
        assertEquals("55621", new Solution01("src/main/resources/Input01.txt").solveFirstPart());
    }
}
