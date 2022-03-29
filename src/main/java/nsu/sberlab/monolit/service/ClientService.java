package nsu.sberlab.monolit.service;

import nsu.sberlab.monolit.domain.model.BankClient;
import nsu.sberlab.monolit.infrastucture.postgres.BankClientRepo;
import nsu.sberlab.monolit.infrastucture.postgres.CardRepository;
import nsu.sberlab.monolit.infrastucture.postgres.CreditRepository;
import nsu.sberlab.monolit.infrastucture.postgres.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ClientService {
    @Autowired
    private BankClientRepo clientRepo;
    @Autowired
    private CardRepository cardRepo;
    @Autowired
    private CreditRepository creditRepo;
    @Autowired
    private DepositRepository depositRepo;

    public boolean findClientById(int id) {
        try {
            clientRepo.findById(id);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean findFullClientById(int id) {
        try {
            clientRepo.findById(id);
            cardRepo.findByClientId(id);
            creditRepo.findByClientId(id);
            depositRepo.findByClientId(id);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
