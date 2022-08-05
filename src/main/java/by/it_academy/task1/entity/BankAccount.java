package by.it_academy.task1.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class BankAccount {

    private String number;
    private String bank;
    private BigDecimal balance;
    private boolean blocked;

    public BankAccount(String number, String bank, BigDecimal balance, boolean blocked) {
        this.number = number;
        this.bank = bank;
        this.balance = balance;
        this.blocked = blocked;
    }

    public BankAccount(String number, BigDecimal balance) {
        this.number = number;
        this.balance = balance;
        this.blocked = false;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return blocked == that.blocked && Objects.equals(number, that.number) && Objects.equals(bank, that.bank) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, bank, balance, blocked);
    }
}
