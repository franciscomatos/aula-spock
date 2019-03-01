package pt.ulisboa.tecnico.softeng.bank.domain
import spock.lang.Specification


class SpecificationTest extends Specification {
    def "one plus one should equal two"() {
        given:
        def first = 2     //exemplo com def   
        int second = 2    //exemplo com int 

        when:
        def result = first + second     

        then:        
        result == 4
    }
}