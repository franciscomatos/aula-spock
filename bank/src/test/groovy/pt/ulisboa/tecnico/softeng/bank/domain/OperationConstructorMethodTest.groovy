package pt.ulisboa.tecnico.softeng.bank.domain

import spock.lang.Specification
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import pt.ulisboa.tecnico.softeng.bank.domain.Operation.Type

class OperationConstructorMethodTest extends Specification {
    Logger logger = LoggerFactory.getLogger(OperationConstructorMethodTest.class)

    Bank bank
    Account account

    def setup() {
        bank = new Bank("Money", "BK01")
        Client client = new Client(this.bank, "António")
        account = new Account(this.bank, client)
    }

    def 'test operation construction' () {
        given: 'new operation'
        Operation operation = new Operation(Type.DEPOSIT, account, 1000)

        expect: 'correct initial attributes'
        operation.getReference().startsWith(this.bank.getCode())
        operation.getReference().length() > Bank.CODE_SIZE
        operation.getType() == Type.DEPOSIT
        operation.getAccount() == account
        operation.getValue() == 1000
        operation.getTime() != null
        bank.getOperation(operation.getReference()) == operation
    }

    def cleanup() {
        bank.banks.clear()
    }
}