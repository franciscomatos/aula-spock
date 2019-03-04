package pt.ulisboa.tecnico.softeng.bank.domain

import spock.lang.Specification

class AccountDepositMethodTest extends Specification {
    Bank bank
    Account account

    def setup() {
        bank = new Bank("Money", "BK01")
        Client client = new Client(this.bank, "António")
        account = new Account(this.bank, client)
    }

    def 'deposit' () {
        given:
        String reference = account.deposit(50)
        Operation operation = bank.getOperation(reference)

        expect:
        account.getBalance() == 50
        operation.getType() == Operation.Type.DEPOSIT
        operation.getAccount() == account
        operation.getValue() == 50
    }

    def cleanup() {
        bank.banks.clear()
    }
}