package eu.joajar.aoc2023.solutions;

import java.util.Arrays;
import java.util.List;

public class Solution02 extends DataReaderAndAbstractPuzzle {
    public Solution02(String fileName) {
        super(fileName);
    }

    @Override
    public int getDayNumber() {
        return 2;
    }

    @Override
    public String solveFirstPart() {
        final int sumOfIdsForPossibleGames = getDataAsStreamOfDataFileLines()
                .map(Game::transformStringIntoGame)
                .filter(Game::isGamePossible)
                .mapToInt(game -> game.id)
                .sum();
        return String.valueOf(sumOfIdsForPossibleGames);
    }

    @Override
    public String solveSecondPart() {
        return null;
    }

    private record Cubes(int number, Color color) {
        private static Cubes transform(String[] array) {
            return new Cubes(
                    Integer.parseInt(array[0]),
                    Color.valueOf(array[1].toUpperCase())
            );
        }

        /**  Below check areCubesPossible is based on the following observation: 14 = the maximal number of BLUE cubes possible + 0 =
         = Color.BLUE.ordinal() + number of BLUE cubes contained in a bag
         = the maximal number of GREEN cubes possible + 1
         = Color.GREEN.ordinal() + number of GREEN cubes contained in a bag
         = the maximal number of RED cubes possible + 2
         = Color.RED.ordinal() + number of RED cubes contained in a bag
         This means that for every object Cubes(number,color), this object is possible iff number + color.ordinal() <= 14
         */
        private static final Integer maximalIndexOfPossibleCubes = 14;

        private static Integer calculateIndex(Cubes cubes) {
            return cubes.number + cubes.color.ordinal();
        }

        private static boolean areCubesPossible(Cubes cubes) {
            return maximalIndexOfPossibleCubes >= Cubes.calculateIndex(cubes);
        }
    }

    private record Game(int id, List<Cubes> listOfCubes) {
        private static Game transformStringIntoGame(String aString) {
            final var indexOfColon = aString.indexOf(":");
            final var indexOfIdFirstDigit = 5;
            return new Game(
                    Integer.parseInt(aString.substring(indexOfIdFirstDigit, indexOfColon)),
                    Arrays.stream(aString.substring(indexOfColon + 2).split("[;,]\\s*"))
                            .map(Game::splitString)
                            .map(Cubes::transform)
                            .toList()
            );
        }

        private static boolean isGamePossible(Game game) {
            return game.listOfCubes.stream().allMatch(Cubes::areCubesPossible);
        }

        private static String[] splitString(String aString) {
            return aString.split("\\s");
        }
    }

    private enum Color {
        BLUE, GREEN, RED
    }
}
