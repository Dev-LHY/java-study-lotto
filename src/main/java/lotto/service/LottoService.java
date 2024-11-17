package lotto.service;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.model.Rank;

public class LottoService {
    private final Map<Rank, Integer> winningStatistics = new LinkedHashMap<>();

    private void initializeWinningStatistics() {
        for (Rank rank : Rank.values()) {
            winningStatistics.put(rank, 0);
        }
    }
}
