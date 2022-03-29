package nsu.sberlab.monolit.service;

import nsu.sberlab.monolit.domain.model.Credit;
import nsu.sberlab.monolit.domain.model.Deposit;
import nsu.sberlab.monolit.infrastucture.postgres.CreditRepository;
import nsu.sberlab.monolit.infrastucture.postgres.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DepositService {
    @Autowired
    private DepositRepository depositRepo;

    public boolean createDeposit(Deposit deposit) {
        try {
            depositRepo.createDeposit(deposit);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean findByClientId(int id) {
        try {
            depositRepo.findByClientId(id);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
