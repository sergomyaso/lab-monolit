package nsu.sberlab.monolit.infrastucture.postgres;

import nsu.sberlab.monolit.domain.model.Card;
import nsu.sberlab.monolit.domain.model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

@Component
public class CreditRepository {
    @Autowired
    private Connection db;

    public void createCredit(Credit credit) throws SQLException {
        String query = "INSERT into credits (\"clientId\", \"summary\", \"percent\", \"payDay\") VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = db.prepareStatement(query);
            st.setInt(1, credit.getClientId());
            st.setFloat(2, credit.getSummary());
            st.setFloat(3, credit.getPercent());
            st.setInt(4, credit.getPayDay());
            st.execute();
        } catch (SQLException e) {
            Logger.getLogger("logger").info("Gark in createCredit of CreditRepo, err:" + e.getMessage());

            throw e;
        }
    }

    public void findByClientId(int clientId) throws SQLException {
        String query = "SELECT * from credits WHERE \"clientId\" in (?)";
        try {
            PreparedStatement st = db.prepareStatement(query);
            st.setInt(1, clientId);
            st.execute();
        } catch (SQLException e) {
            Logger.getLogger("logger").info("Gark in findByClientId of CreditRepo, err:" + e.getMessage());

            throw e;
        }
    }
}
