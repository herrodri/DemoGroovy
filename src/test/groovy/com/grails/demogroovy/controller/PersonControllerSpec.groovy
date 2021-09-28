package com.grails.demogroovy.controller

import person.PersonController
import com.grails.demogroovy.dto.PersonDto
import com.grails.demogroovy.service.CrudPersonService
import grails.testing.web.controllers.ControllerUnitTest
import org.springframework.http.HttpStatus
import spock.lang.Specification

class PersonControllerSpec extends Specification implements ControllerUnitTest<PersonController> {

    def setup() {
    }

    def cleanup() {
    }

    void "given person with correct information should return 200 code"() {

        given:
        PersonDto person = new PersonDto()
        person.setDocumentNumber("12345678")
        person.setFirstName("Fabian")
        person.setLastName("Giraldo")
        person.setAge(26)

        controller.crudPersonService = Stub(CrudPersonService) {
            savePerson(_) >> person
        }
        when:
            controller.save(person)

        then:
        assert response
        assert response.status == HttpStatus.OK.value()
    }
}