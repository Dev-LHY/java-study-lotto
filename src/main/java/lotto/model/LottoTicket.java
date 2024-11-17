package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTicket = new ArrayList<>();

    public void purchaseLottoTicket(int quantity) {
        for (int i = 0; i < quantity; i++) {
            addLotto(new Lotto(Lotto.generateLotto()));
        }
    }

    private void addLotto(Lotto lotto) {
        lottoTicket.add(lotto);
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }
}
