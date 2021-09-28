package com.groovy.demogroovy.service

import person.Person
import grails.testing.mixin.integration.Integration
import person.PersonService
import spock.lang.Specification

@Integration
class PersonServiceTest extends Specification {

    PersonService personService

    void "Test find person by document number successfully" () {
        given:
        Person person = new Person()
        person.setDocumentNumber("12345678")
        person.setFirstName("Julio")
        person.setLastName("Acosta")
        person.setAge(24)

        Person personExpected = personService.savePerson(person)

        when:
        Person personResult = personService.findPersonByDocumentNumber("12345678")

        then:
        personResult.getDocumentNumber() == personExpected.getDocumentNumber()

    }
}
