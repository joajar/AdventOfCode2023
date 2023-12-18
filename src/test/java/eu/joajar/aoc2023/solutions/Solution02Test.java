package eu.joajar.aoc2023.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution02Test {
    @Test
    public void firstPartOfSolution02Test() {
        assertEquals("8", new Solution02("src/test/resources/Input02.txt").solveFirstPart());
    }

    @Test
    public void firstPartOfSolution02WithFinalDataTest() {
        assertEquals("2563", new Solution02("src/main/resources/Input02.txt").solveFirstPart());
    }

    @Test
    public void secondPartOfSolution02Test() {
        assertEquals("2286", new Solution02("src/test/resources/Input02.txt").solveSecondPart());
    }

    @Test
    public void secondPartOfSolution02WithFinalDataTest() {
        assertEquals("70768", new Solution02("src/main/resources/Input02.txt").solveSecondPart());
    }
}
