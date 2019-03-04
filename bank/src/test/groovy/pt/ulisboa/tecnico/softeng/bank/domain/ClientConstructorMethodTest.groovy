package pt.ulisboa.tecnico.softeng.bank.domain

import spock.lang.Specification

class ClientConstructorMethodTest extends Specification {

    Bank bank

    def setup() {
        bank = new Bank("Money", "BK01")
    }

    def 'test client constrution' () {
        given: 'a new client'
        Client client = new Client(this.bank, "António")

        expect: 'correct initial attributes'
        client.getName() == "António"
        client.getID().length() >= 1
        bank.hasClient(client)
    }

    def cleanup() {
        bank.banks.clear()
    }
}