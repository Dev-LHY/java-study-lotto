package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.model.LottoTicket;
import lotto.model.Money;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Money money = retryIfErrorOccur(this::setMoney);
        int quantity = money.getPurchaseQuantity();

        LottoTicket lottoTicket = setLottoTicket(quantity);

        WinningNumbers winningNumbers = retryIfErrorOccur(this::setWinningNumbers);

        winningStatistics(lottoTicket, winningNumbers, money);
    }

    private Money setMoney() {
        return new Money(inputView.money());
    }

    private LottoTicket setLottoTicket(int quantity) {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.purchaseLottoTicket(quantity);
        outputView.purchaseLotto(lottoTicket.getLottoTicket());
        return lottoTicket;
    }

    private WinningNumbers setWinningNumbers() {
        List<Integer> winningNumber = inputView.winningNumbers();
        int bonusNumber = inputView.bonusNumber();
        return new WinningNumbers(winningNumber, bonusNumber);
    }

    private void winningStatistics(LottoTicket lottoTicket, WinningNumbers winningNumbers, Money money) {
        LottoService lottoService = new LottoService();
        lottoService.createWinningStatistics(lottoTicket.getLottoTicket(), winningNumbers);

        Integer[] winningStatisticsCount = lottoService.getWinningStatisticsCount();
        double rateOfReturn = lottoService.getRateOfReturn(money.getMoney());

        outputView.result(winningStatisticsCount, rateOfReturn);
    }

    private <T> T retryIfErrorOccur(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
