package pt.ulisboa.tecnico.softeng.bank.domain

import spock.lang.Specification

class BankConstructorTest extends Specification {

    Bank bank

    def setup() throws Exception{
        bank = new Bank("Money", "BK01")
    }

    def 'test bank construction'() {
        given: 'a new bank account'

        when: 'nothing'

        then: 'initial attributes '
        bank.getName() == "Money"
        bank.getCode() == "BK01"
        bank.banks.size() == 1
        bank.getNumberOfAccounts() == 0
        bank.getNumberOfClients() == 0
    }

    def cleanup() {
        bank.banks.clear()
    }
}