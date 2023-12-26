package eu.joajar.aoc2023.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution06Test {
    @Test
    public void firstPartOfSolution01Test() {
        assertEquals("288", new Solution06("src/test/resources/Input06.txt").solveFirstPart());
    }

    @Test
    public void firstPartOfSolution01WithFinalDataTest() {
        assertEquals("2374848", new Solution06("src/main/resources/Input06.txt").solveFirstPart());
    }
}

