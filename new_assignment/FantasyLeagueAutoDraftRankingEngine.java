package new_assignment;

import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Established player rule
        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 10;
        }

        // New player / combined fitness rule
        static boolean isDraftable(int matchesPlayed,
                                    double battingAverage,
                                    boolean injured) {
            return matchesPlayed >= 5
                    && battingAverage >= 50.0
                    && !injured;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    static Player[] draftAndRank(Player[] players) {

        int count = 0;

        // Count draftable players
        for (Player p : players) {

            boolean draftable;

            if (p.matchesPlayed >= 10) {
                draftable = Player.isDraftable(
                        p.matchesPlayed,
                        p.injured
                );
            } else {
                draftable = Player.isDraftable(
                        p.matchesPlayed,
                        p.battingAverage,
                        p.injured
                );
            }

            if (draftable) {
                count++;
            }
        }

        // Create draftable array
        Player[] draftable = new Player[count];
        int index = 0;

        for (Player p : players) {

            boolean isSelected;

            if (p.matchesPlayed >= 10) {
                isSelected = Player.isDraftable(
                        p.matchesPlayed,
                        p.injured
                );
            } else {
                isSelected = Player.isDraftable(
                        p.matchesPlayed,
                        p.battingAverage,
                        p.injured
                );
            }

            if (isSelected) {
                draftable[index++] = p;
            }
        }

        // Sort by batting average in descending order
        Arrays.sort(draftable);

        return draftable;
    }

    public static void main(String[] args) {

        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        Player[] result = draftAndRank(players);

        System.out.print("Draft Rank: ");

        for (int i = 0; i < result.length; i++) {
            System.out.print((i + 1) + ". " + result[i].name);

            if (i < result.length - 1) {
                System.out.print(" | ");
            }
        }
    }
}