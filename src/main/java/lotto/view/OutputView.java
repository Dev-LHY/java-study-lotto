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
}
