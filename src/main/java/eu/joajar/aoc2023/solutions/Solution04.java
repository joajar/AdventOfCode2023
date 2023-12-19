package eu.joajar.aoc2023.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution04 extends DataReaderAndAbstractPuzzle {
    public Solution04(String fileName) {
        super(fileName);
    }

    @Override
    public int getDayNumber() {
        return 4;
    }

    @Override
    public String solveFirstPart() {
        final int totalNumberOfPoints = getDataAsStreamOfDataFileLines()
                .map(Card::transform)
                .mapToInt(Card::calculatePoints)
                .sum();

        return String.valueOf(totalNumberOfPoints);
    }

    private record Card(Set<Integer> winningNumbers, Set<Integer> myNumbers) {
        private static Card transform(String aString) {
            final var indexOfColon = aString.indexOf(":");
            final var indexOfPipe = aString.indexOf("|");

            return new Card(
                    formSetOfIntegers(aString.substring(indexOfColon + 1, indexOfPipe)),
                    formSetOfIntegers(aString.substring(indexOfPipe + 1))
            );
        }

        private static Set<Integer> formSetOfIntegers(String aString) {
            return Arrays.stream(aString.split("\\s"))
                    .filter(a->!a.isEmpty())
                    .map(Integer::valueOf)
                    .collect(Collectors.toSet());
        }

        private static int calculatePoints(Card card) {
            return (int) Math.pow(2, calculateIntersectionCardinality(card) - 1);
        }

        private static int calculateIntersectionCardinality(Card card) {
            Set<Integer> intersection = calculateIntersection(card);
            return intersection.size();
        }

        private static Set<Integer> calculateIntersection(Card card) {
            var intersection = new HashSet<>(card.winningNumbers);
            intersection.retainAll(card.myNumbers);
            return intersection;
        }
    }

    @Override
    public String solveSecondPart() {
        return null;
    }
}
