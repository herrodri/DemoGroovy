package com.grails.demogroovy.dto

import grails.testing.gorm.DomainUnitTest
import person.Person
import spock.lang.Specification

class PersonSpec extends Specification implements DomainUnitTest<Person> {

    def setup() {
    }

    def cleanup() {
    }

    void "test documentNumber cannot length min 8 characters"() {
        when:
            domain.documentNumber = "1234567"

        then:
            !domain.validate(['documentNumber'])
            domain.errors['documentNumber'].code == 'nullable'
    }
}
