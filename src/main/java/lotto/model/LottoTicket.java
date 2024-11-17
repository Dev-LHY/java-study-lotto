package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTicket = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottoTicket.add(lotto);
    }
}
