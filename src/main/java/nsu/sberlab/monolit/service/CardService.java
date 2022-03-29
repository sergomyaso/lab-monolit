package nsu.sberlab.monolit.service;

import nsu.sberlab.monolit.domain.model.BankClient;
import nsu.sberlab.monolit.domain.model.Card;
import nsu.sberlab.monolit.infrastucture.postgres.BankClientRepo;
import nsu.sberlab.monolit.infrastucture.postgres.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepo;

    public boolean createCard(Card card) {
        try {
            cardRepo.createCard(card);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean findByClientId(int id) {
        try {
            cardRepo.findByClientId(id);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
