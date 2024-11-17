package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public void purchaseLotto(List<Lotto> lottos) {
        System.out.println(System.lineSeparator() +
                OutputMessage.PURCHASE_AMOUNT.getFormatMessage(lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void result(Integer[] winningStatisticsCount, double rateOfReturn) {
        resultOfWinning(winningStatisticsCount);
        rateOfReturn(rateOfReturn);
    }

    private void resultOfWinning(Integer[] winningStatisticsCount) {
        System.out.println(System.lineSeparator() +
                OutputMessage.WINNING_STATISTICS.getFormatMessage((Object[]) winningStatisticsCount));
    }

    private void rateOfReturn(double rateOfReturn) {
        System.out.println(OutputMessage.RATE_OF_RETURN.getFormatMessage(rateOfReturn));
    }
}
