package by.it_academy.task1.service.impl;

import by.it_academy.task1.entity.BankAccount;
import by.it_academy.task1.entity.Client;
import by.it_academy.task1.service.BankAccountService;
import by.it_academy.task1.service.ClientService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    private final BankAccountService bankAccountService;

    public ClientServiceImpl(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Override
    public Optional<BankAccount> findClientAccount(Client client, String accountNumber) {
        List<BankAccount> bankAccounts = client.getBankAccounts();
        return bankAccountService.findAccount(bankAccounts, accountNumber);
    }

    @Override
    public List<BankAccount> sortClientAccountsByBalance(Client client) {
        List<BankAccount> bankAccounts = client.getBankAccounts();
        return bankAccountService.sortAccountsByBalance(bankAccounts);
    }

    @Override
    public BigDecimal calculateTotalBills(Client client) {
        List<BankAccount> bankAccounts = client.getBankAccounts();
        return bankAccounts.stream()
                .map(BankAccount::getBalance)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

    @Override
    public BigDecimal calculatePositiveBills(Client client) {
        List<BankAccount> bankAccounts = client.getBankAccounts();
        return bankAccounts.stream()
                .map(BankAccount::getBalance)
                .filter(b -> b.doubleValue() > 0)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

    @Override
    public BigDecimal calculateNegativeBills(Client client) {
        List<BankAccount> bankAccounts = client.getBankAccounts();
        return bankAccounts.stream()
                .map(BankAccount::getBalance)
                .filter(b -> b.doubleValue() < 0)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }
}
