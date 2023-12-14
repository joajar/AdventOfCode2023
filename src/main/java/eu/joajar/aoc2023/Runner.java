package eu.joajar.aoc2023;

import eu.joajar.aoc2023.solutions.DataReaderAndAbstractPuzzle;
import eu.joajar.aoc2023.solutions.Solution01;

import java.util.List;

import static java.util.Objects.nonNull;

public class Runner {

    private static final List<DataReaderAndAbstractPuzzle> PUZZLES = List.of(
            new Solution01("src/main/resources/Input01.txt")
    );

    public static void main(String[] args) {
        PUZZLES.forEach(PUZZLE -> {
            System.out.println("Day " + PUZZLE.getDayNumber() + " part 1 result: " + PUZZLE.solveFirstPart());
            if (nonNull(PUZZLE.solveSecondPart())) {
                System.out.println("Day " + PUZZLE.getDayNumber() + " part 2 result: " + PUZZLE.solveSecondPart());
            }
        });
    }
}
