package eu.joajar.aoc2023.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution04Test {
    @Test
    public void firstPartOfSolution04Test() {
        assertEquals("13", new Solution04("src/test/resources/Input04.txt").solveFirstPart());
    }

    @Test
    public void firstPartOfSolution04WithFinalDataTest() {
        assertEquals("15268", new Solution04("src/main/resources/Input04.txt").solveFirstPart());
    }
}
