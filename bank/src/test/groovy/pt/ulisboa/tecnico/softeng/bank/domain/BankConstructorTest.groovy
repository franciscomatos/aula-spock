package pt.ulisboa.tecnico.softeng.bank.domain

import spock.lang.Specification

class BankConstructorTest extends Specification {

    def 'test bank construction'() throws Exception {
        given: 'a new bank'
        Bank bank = new Bank("Money", "BK01")

        expect: 'correct initial attributes'
        bank.getName() == "Money"
        bank.getCode() == "BK01"
        bank.banks.size() == 1
        bank.getNumberOfAccounts() == 0
        bank.getNumberOfClients() == 0

        cleanup:
        bank.banks.clear()
    }

}