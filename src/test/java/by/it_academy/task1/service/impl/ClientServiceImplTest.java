package by.it_academy.task1.service.impl;

import by.it_academy.task1.entity.BankAccount;
import by.it_academy.task1.entity.Client;
import by.it_academy.task1.service.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientServiceImplTest {

    private final ClientService clientService = new ClientServiceImpl(new BankAccountServiceImpl());

    private Client client;

    @BeforeEach
    void init() {
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccount("BY135F7Z4693CY1KE80SH7ES982P", BigDecimal.valueOf(-23410.45D)));
        bankAccounts.add(new BankAccount("BY42TAFM1561V3KAOHXYFRROAD7S", BigDecimal.valueOf(-3.40D)));
        bankAccounts.add(new BankAccount("BY73O8BU2301KYDZYGICPTSJ97CN", BigDecimal.valueOf(70468.70D)));
        client = new Client("Jane", bankAccounts);
    }

    @Test
    void calculateTotalBills() {
        BigDecimal result = clientService.calculateTotalBills(client);
        Assertions.assertEquals(result, BigDecimal.valueOf(47054.85D));
    }

    @Test
    void calculatePositiveBills() {
        BigDecimal result = clientService.calculatePositiveBills(client);
        Assertions.assertEquals(result, BigDecimal.valueOf(70468.70D));
    }

    @Test
    void calculateNegativeBills() {
        BigDecimal result = clientService.calculateNegativeBills(client);
        Assertions.assertEquals(result, BigDecimal.valueOf(-23413.85D));
    }

    @Test
    void findClientAccount() {
        Optional<BankAccount> bankAccount = clientService.findClientAccount(client, "BY42TAFM1561V3KAOHXYFRROAD7S");
        Assertions.assertEquals(bankAccount.get(), client.getBankAccounts().get(1));
        bankAccount = clientService.findClientAccount(client, "222");
        Assertions.assertTrue(bankAccount.isEmpty());
    }
}
