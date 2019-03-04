package pt.ulisboa.tecnico.softeng.bank.domain

import spock.lang.Specification

class BankHasAccountMethodTest extends Specification {
    Bank bank
    Client client

    def setup() {
        bank = new Bank("Money", "BK01")
        client = new Client(bank, "António")
    }

    def 'check for account' () {
        given: 'a new account'
        Account account = new Account(bank, client)

        when: 'get bank account'
        Account result = bank.getAccount(account.getIBAN())

        then:
        account == result
    }

    def cleanup() {
        bank.banks.clear()
    }
}