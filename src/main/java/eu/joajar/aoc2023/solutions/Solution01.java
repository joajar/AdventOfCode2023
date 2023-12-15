package eu.joajar.aoc2023.solutions;

import java.util.Arrays;
import java.util.Map;

public class Solution01 extends DataReaderAndAbstractPuzzle {
    private final Map<String, String> theMapping = Map.of(
            "one", "o1e",
            "two", "t2o",
            "three", "t3e",
            "four", "f4r",
            "five", "f5e",
            "six", "s6x",
            "seven", "s7n",
            "eight", "e8t",
            "nine", "n9e"
    );

    public Solution01(String fileName) {
        super(fileName);
    }

    @Override
    public int getDayNumber() {
        return 1;
    }

    @Override
    public String solveFirstPart() {
        long result = getDataAsStreamOfDataFileLines()
                .mapToInt(this::removeLettersAndFormNumberConsistedOfFirstAndLastDigitElseZero)
                .sum();

        return String.valueOf(result);
    }

    @Override
    public String solveSecondPart() {
        long result = Arrays.stream(getDataAsArrayOfDataFileLines())
                .map(this::exchangeWordsWithDigits)
                .mapToInt(this::removeLettersAndFormNumberConsistedOfFirstAndLastDigitElseZero)
                .sum();

        return String.valueOf(result);
    }

    private int removeLettersAndFormNumberConsistedOfFirstAndLastDigitElseZero(String aString) {
        String newString = aString.replaceAll("\\p{L}", "");
        if (newString.isEmpty()) {
            return 0;
        }
        return Integer.parseInt("" + newString.charAt(0) + newString.charAt(newString.length() - 1));
    }

    private String exchangeWordsWithDigits(String aString) {
        for (Map.Entry<String, String> entryForTheMapping: theMapping.entrySet()) {
            aString = aString.replaceAll(entryForTheMapping.getKey(), entryForTheMapping.getValue());
        }
        return aString;
    }
}
