package com.grails.demogroovy.dto

import grails.testing.web.controllers.ControllerUnitTest
import groovy.json.JsonSlurper
import org.springframework.http.HttpStatus
import spock.lang.Specification

class PersonControllerSpec extends Specification implements ControllerUnitTest<PersonController> {

    def setup() {
    }

    def cleanup() {
    }

    void "save person with correct information "() {

        given:
        PersonDto person = new PersonDto()
        person.setDocumentNumber("12345678")
        person.setFirstName("Fabian")
        person.setLastName("Giraldo")
        person.setAge(26)

        controller.personService = Stub(PersonService) {
            save(_) >> person
        }
        when:
            controller.save(person)

        then:
        assert response
        assert response.status == HttpStatus.OK.value()
    }
}