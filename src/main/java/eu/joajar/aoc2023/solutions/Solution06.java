package eu.joajar.aoc2023.solutions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution06 extends DataReaderAndAbstractPuzzle {
    public Solution06(String fileName) {
        super(fileName);
    }

    @Override
    public int getDayNumber() {
        return 6;
    }

    @Override
    public String solveFirstPart() {
        int[][] parsedData = parseData();

        Long result = IntStream
                .range(0, parsedData[0].length)
                .mapToLong(
                        j -> IntStream
                                .range(0, parsedData[0][j])
                                .filter(k -> k * (parsedData[0][j] - k)  > parsedData[1][j])
                                .count()
                )
                .reduce((a,b) -> a*b)
                .orElse(0);

        return String.valueOf(result);
    }

    private int[][] parseData() {
        int[][] dataParsedTo2DimArray = new int[data.length][];

        IntStream
                .range(0, data.length)
                .forEach(i -> dataParsedTo2DimArray[i] = Arrays
                        .stream(data[i]
                                .replaceAll("\\s+", " ")
                                .split("\\s")
                        )
                        .filter(aString -> !aString.contains(":"))
                        .mapToInt(Integer::valueOf)
                        .toArray()
                );

        return dataParsedTo2DimArray;
    }

    @Override
    public String solveSecondPart() {
        return null;
    }
}
