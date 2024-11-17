package lotto.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Rank;

public class LottoService {
    private static final int SCALING_FACTOR = 100;
    private final Map<Rank, Integer> winningStatistics = new LinkedHashMap<>();

    public Integer[] getWinningStatisticsCount() {
        Integer[] winningStatisticsCount = new Integer[5];
        int i = 0;
        for (Rank rank : Rank.values()) {
            winningStatisticsCount[i] = winningStatistics.get(rank);
            i++;
        }
        return winningStatisticsCount;
    }

    public double getRateOfReturn(int money) {
        double totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += (rank.getPrize() * winningStatistics.get(rank));
        }
        return (totalPrize / money) * SCALING_FACTOR;
    }

    private void updateWinningStatistics(int matchCount, boolean isBonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.checkRank(matchCount, isBonusMatch)) {
                Integer count = winningStatistics.get(rank);
                winningStatistics.put(rank, ++count);
            }
        }
    }

    private void initializeWinningStatistics() {
        for (Rank rank : Rank.values()) {
            winningStatistics.put(rank, 0);
        }
    }

    private int getMatchCount(List<Integer> numbers, List<Integer> winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::contains)
                .count();
    }

    private boolean isBonusMatch(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
