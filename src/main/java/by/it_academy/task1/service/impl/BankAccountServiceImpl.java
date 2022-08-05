package by.it_academy.task1.service.impl;

import by.it_academy.task1.entity.BankAccount;
import by.it_academy.task1.service.BankAccountService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BankAccountServiceImpl implements BankAccountService {

    @Override
    public void blockAccount(BankAccount bankAccount) {
        bankAccount.setBlocked(true);
    }

    @Override
    public void unlockAccount(BankAccount bankAccount) {
        bankAccount.setBlocked(false);
    }

    @Override
    public Optional<BankAccount> findAccount(List<BankAccount> bankAccounts, String accountNumber) {
        return bankAccounts.stream()
                .filter(account -> accountNumber.equals(account.getNumber()))
                .findAny();
    }

    @Override
    public List<BankAccount> sortAccountsByBalance(List<BankAccount> bankAccounts) {
        return bankAccounts.stream()
                .sorted(Comparator.comparingDouble(b -> b.getBalance().doubleValue()))
                .collect(Collectors.toList());
    }
}
