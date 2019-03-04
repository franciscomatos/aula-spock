package pt.ulisboa.tecnico.softeng.bank.domain

import spock.lang.Specification

class AccountWithdrawMethodTest extends Specification {
    Bank bank
    Account account

    def setup() {
        bank = new Bank("Money", "BK01")
        Client client = new Client(bank, "António")
        account = new Account(bank, client)
        account.deposit(100)
    }

    def 'withdraw'() {
        given:
        String reference = account.withdraw(40)
        Operation operation = bank.getOperation(reference)

        expect:
        account.getBalance() == 60
        operation.getType() == Operation.Type.WITHDRAW
        operation.getAccount() == account
        operation.getValue() == 40
    }

    def cleanup() {
        bank.banks.clear()
    }
}