package nsu.sberlab.monolit.controller;

import nsu.sberlab.monolit.domain.model.BankClient;
import nsu.sberlab.monolit.domain.model.Card;
import nsu.sberlab.monolit.domain.model.Credit;
import nsu.sberlab.monolit.domain.model.Deposit;
import nsu.sberlab.monolit.service.CardService;
import nsu.sberlab.monolit.service.ClientService;
import nsu.sberlab.monolit.service.CreditService;
import nsu.sberlab.monolit.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    CardService cardService;
    @Autowired
    CreditService creditService;
    @Autowired
    DepositService depositService;

    @GetMapping("/client/{client_id}")
    public boolean getClientById(@PathVariable("client_id") int clientId) {
        return clientService.findClientById(clientId);
    }

    @PostMapping("/card/create")
    public boolean createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @GetMapping("/card/{client_id}")
    public boolean getCardByClientId(@PathVariable("client_id") int clientId) {
        return cardService.findByClientId(clientId);
    }

    @PostMapping("/credit/create")
    public boolean createCredit(@RequestBody Credit credit) {
        return creditService.createCard(credit);
    }

    @GetMapping("/credit/{client_id}")
    public boolean getCreditByClientId(@PathVariable("client_id") int clientId) {
        return creditService.findByClientId(clientId);
    }

    @PostMapping("/deposit/create")
    public boolean createDeposit(@RequestBody Deposit deposit) {
        return depositService.createDeposit(deposit);
    }

    @GetMapping("/deposit/{client_id}")
    public boolean getDepositByClientId(@PathVariable("client_id") int clientId) {
        return depositService.findByClientId(clientId);
    }

    @GetMapping("/full/{client_id}")
    public boolean getFullClientInformation(@PathVariable("client_id") int clientId) {
        return clientService.findFullClientById(clientId);
    }
}

//////////////////////////////////////// requests examples ////////////////////////

//create card
//       {
//        "clientId":1,
//        "cardNumber":"fndsnds",
//        "expiredAt":"2022-04-27T15:51:10+07:00",
//        "cardType":"heriza"
//        }

//create credit
//       {
//        "clientId":1,
//        "summary":1200.5,
//        "percent":35.5,
//        "payDay":21
//        }

//create deposit
//       {
//        "clientId":1,
//        "summary":1200.5,
//        "percent":35.5,
//        "createdAt":"2022-04-27T15:51:10+07:00"
//        }