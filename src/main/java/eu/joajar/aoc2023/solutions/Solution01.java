package eu.joajar.aoc2023.solutions;

public class Solution01 extends DataReaderAndAbstractPuzzle {
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
                .map(aString -> aString.replaceAll("[\\p{L}]", ""))
                .filter(aString -> !aString.isEmpty())
                .map(aString -> "" + aString.charAt(0) + aString.charAt(aString.length() - 1))
                .mapToInt(Integer::parseInt).sum();

        return String.valueOf(result);
    }

    @Override
    public String solveSecondPart() {
        return null;
    }
}
