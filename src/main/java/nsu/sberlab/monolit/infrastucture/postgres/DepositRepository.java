package nsu.sberlab.monolit.infrastucture.postgres;

import nsu.sberlab.monolit.domain.model.Credit;
import nsu.sberlab.monolit.domain.model.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

@Component
public class DepositRepository {
    @Autowired
    private Connection db;

    public void createDeposit(Deposit deposit) throws SQLException {
        String query = "INSERT into credits (\"clientId\", \"summary\", \"percent\", \"createdAt\") VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = db.prepareStatement(query);
            st.setInt(1, deposit.getClientId());
            st.setFloat(2, deposit.getSummary());
            st.setFloat(3, deposit.getPercent());
            st.setObject(4, deposit.getCreatedAt());
            st.execute();
        } catch (SQLException e) {
            Logger.getLogger("logger").info("Gark in createDeposit of DepositRepo, err:" + e.getMessage());

            throw e;
        }
    }

    public void findByClientId(int clientId) throws SQLException {
        String query = "SELECT * from deposits WHERE \"clientId\" in (?)";
        try {
            PreparedStatement st = db.prepareStatement(query);
            st.setInt(1, clientId);
            st.execute();
        } catch (SQLException e) {
            Logger.getLogger("logger").info("Gark in findByClientId of DepositsRepo, err:" + e.getMessage());

            throw e;
        }
    }
}
