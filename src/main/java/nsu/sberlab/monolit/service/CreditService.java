package nsu.sberlab.monolit.service;

import nsu.sberlab.monolit.domain.model.Card;
import nsu.sberlab.monolit.domain.model.Credit;
import nsu.sberlab.monolit.infrastucture.postgres.CardRepository;
import nsu.sberlab.monolit.infrastucture.postgres.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CreditService {
    @Autowired
    private CreditRepository creditRepo;

    public boolean createCard(Credit credit) {
        try {
            creditRepo.createCredit(credit);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean findByClientId(int id) {
        try {
            creditRepo.findByClientId(id);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
