package pt.ulisboa.tecnico.softeng.bank.domain

import spock.lang.Specification

class AccountConstructorMethodTest extends Specification {
    Bank bank
    Client client

    def setup() {
        bank = new Bank("Money", "BK01")
        client = new Client(bank, "António")
    }

    def 'test account construction'() {
        given: 'a new bank account'
        Account account = new Account(bank, client)

        expect: 'correct initial attributes'
        account.getBank() == bank
        account.getIBAN().startsWith(bank.getCode())
        account.getClient() == client
        account.getBalance() == 0
        bank.getNumberOfAccounts() == 1
        bank.hasClient(client)
    }

    def cleanup() {
        Bank.banks.clear()
    }
}