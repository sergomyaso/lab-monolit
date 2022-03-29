package nsu.sberlab.monolit.infrastucture.postgres;

import nsu.sberlab.monolit.domain.model.BankClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

@Component
public class BankClientRepo {
    @Autowired
    private Connection db;

    private BankClient mapClientToModel(ResultSet set) throws SQLException {
        if (!set.next()) {
            throw new SQLException("panic in set result (что-то на постгресянском)");
        }

        BankClient client = new BankClient(
                set.getInt(BankClient.COLUMN_ID),
                set.getString(BankClient.COLUMN_FIRST_NAME),
                set.getString(BankClient.COLUMN_SECOND_NAME),
                set.getString(BankClient.COLUMN_LAST_NAME),
                set.getString(BankClient.COLUMN_PASSPORT)
        );

        return client;
    }

    public void findById(int id) throws SQLException {
        String query = "SELECT * from clients WHERE id in (?)";
        BankClient client = null;

        try {
            PreparedStatement preparedStatement = db.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
           // client = mapClientToModel(resultSet);
        } catch (SQLException e) {
            Logger.getLogger("logger").info("Gark in findById Client Bank repo, err:" + e.getMessage());

            throw e;
        }
    }
}
