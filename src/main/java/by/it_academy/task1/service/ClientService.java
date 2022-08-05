package by.it_academy.task1.service;

import by.it_academy.task1.entity.BankAccount;
import by.it_academy.task1.entity.Client;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ClientService {

    public Optional<BankAccount> findClientAccount(Client client, String accountNumber);

    public List<BankAccount> sortClientAccountsByBalance(Client client);

    public BigDecimal calculateTotalBills(Client client);

    public BigDecimal calculatePositiveBills(Client client);

    public BigDecimal calculateNegativeBills(Client client);
}
