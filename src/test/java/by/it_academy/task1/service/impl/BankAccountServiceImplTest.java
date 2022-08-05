package by.it_academy.task1.service.impl;

import by.it_academy.task1.entity.BankAccount;
import by.it_academy.task1.service.BankAccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankAccountServiceImplTest {

    private final BankAccountService bankAccountService = new BankAccountServiceImpl();
    private List<BankAccount> bankAccounts;

    @BeforeEach
    void init() {
        bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccount("BY135F7Z4693CY1KE80SH7ES982P", BigDecimal.valueOf(1000D)));
        bankAccounts.add(new BankAccount("BY42TAFM1561V3KAOHXYFRROAD7S", BigDecimal.valueOf(-30D)));
        bankAccounts.add(new BankAccount("BY73O8BU2301KYDZYGICPTSJ97CN", BigDecimal.valueOf(768.40D)));
    }

    @Test
    void blockBankAccount() {
        BankAccount bankAccount = bankAccounts.get(1);
        bankAccountService.blockAccount(bankAccount);
        Assertions.assertTrue(bankAccount.isBlocked());
    }

    @Test
    void unlockBankAccount() {
        BankAccount bankAccount = bankAccounts.get(2);
        bankAccountService.blockAccount(bankAccount);
        bankAccountService.unlockAccount(bankAccount);
        Assertions.assertFalse(bankAccount.isBlocked());
    }

    @Test
    void findBankAccount() {
        Optional<BankAccount> bankAccount = bankAccountService.findAccount(bankAccounts, "BY73O8BU2301KYDZYGICPTSJ97CN");
        Assertions.assertEquals(bankAccount.get(), bankAccounts.get(2));
        bankAccount = bankAccountService.findAccount(bankAccounts, "1");
        Assertions.assertTrue(bankAccount.isEmpty());
    }

    @Test
    void sortBankAccounts() {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("BY42TAFM1561V3KAOHXYFRROAD7S", BigDecimal.valueOf(-30D)));
        accounts.add(new BankAccount("BY73O8BU2301KYDZYGICPTSJ97CN", BigDecimal.valueOf(768.40D)));
        accounts.add(new BankAccount("BY135F7Z4693CY1KE80SH7ES982P", BigDecimal.valueOf(1000D)));

        bankAccounts = bankAccountService.sortAccountsByBalance(bankAccounts);
        Assertions.assertEquals(bankAccounts, accounts);
    }

}
