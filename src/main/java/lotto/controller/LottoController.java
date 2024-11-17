package lotto.controller;

import java.util.function.Supplier;
import lotto.model.LottoTicket;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Money money = retryIfErrorOccur(this::setMoney);
        int quantity = money.getPurchaseQuantity();

        LottoTicket lottoTicket = setLottoTicket(quantity);
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

    private <T> T retryIfErrorOccur(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
