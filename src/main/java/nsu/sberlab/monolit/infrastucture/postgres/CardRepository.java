package nsu.sberlab.monolit.infrastucture.postgres;

import nsu.sberlab.monolit.domain.model.BankClient;
import nsu.sberlab.monolit.domain.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

@Component
public class CardRepository {
    @Autowired
    private Connection db;

    public void createCard(Card card) throws SQLException {
        String query = "INSERT into cards (\"clientId\", \"cardNumber\", \"expiredAt\", \"cardType\") VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = db.prepareStatement(query);
            st.setInt(1, card.getClientId());
            st.setString(2, card.getCardNumber());
            st.setObject(3, card.getExpiredAt());
            st.setString(4, card.getCardType());
            st.execute();
        } catch (SQLException e) {
            Logger.getLogger("logger").info("Gark in createCard of CardRepo, err:" + e.getMessage());

            throw e;
        }
    }

    public void findByClientId(int clientId) throws SQLException {
        String query = "SELECT * from cards WHERE \"clientId\" in (?)";
        try {
            PreparedStatement st = db.prepareStatement(query);
            st.setInt(1, clientId);
            st.execute();
        } catch (SQLException e) {
            Logger.getLogger("logger").info("Gark in findByClientId of CardRepo, err:" + e.getMessage());

            throw e;
        }
    }
}

