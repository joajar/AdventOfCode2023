package eu.joajar.aoc2023.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private record Card(int cardIndex, Set<Integer> winningNumbers, Set<Integer> myNumbers) {
        private static Card transform(String aString) {
            final var indexOfColon = aString.indexOf(":");
            final var indexOfPipe = aString.indexOf("|");

            return new Card(
                    Integer.parseInt(aString.substring(0, indexOfColon).replaceAll("\\D","")),
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
        long totalNumberOfScratchcards = calculateTotalNumberOfScratchcards()
                .values()
                .stream()
                .reduce(Integer::sum)
                .orElse(0);

        return String.valueOf(totalNumberOfScratchcards);
    }

    private Map<Integer, Integer> calculateTotalNumberOfScratchcards() {
        String[] data = getDataAsArrayOfDataFileLines();

        Map<Integer, Integer> matchingNumbersForCardIds = Stream.of(data)
                .map(Card::transform)
                .collect(Collectors.toMap(Card::cardIndex, Card::calculateIntersectionCardinality));

        HashMap<Integer, Integer> mutableMapToIterativeCalculationOfCardCopies = new HashMap<>(
                Stream.of(data)
                        .map(Card::transform)
                        .collect(Collectors.toMap(Card::cardIndex, d->1))
        );

        for (int i = 1; i <= data.length; i++) {
            for (int j = 1; j <= matchingNumbersForCardIds.get(i); j++) {
                mutableMapToIterativeCalculationOfCardCopies.put(i+j,
                        mutableMapToIterativeCalculationOfCardCopies.get(i) + mutableMapToIterativeCalculationOfCardCopies.get(i+j)
                );
            }
        }

        return mutableMapToIterativeCalculationOfCardCopies;
    }
}
