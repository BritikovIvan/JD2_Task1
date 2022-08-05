package by.it_academy.task1.service;

import by.it_academy.task1.entity.BankAccount;
import by.it_academy.task1.entity.Client;

import java.util.List;
import java.util.Optional;

public interface BankAccountService {

    public void blockAccount(BankAccount bankAccount);

    public void unlockAccount(BankAccount bankAccount);

    public Optional<BankAccount> findAccount(List<BankAccount> bankAccounts, String accountNumber);

    public List<BankAccount> sortAccountsByBalance(List<BankAccount> bankAccounts);
}
