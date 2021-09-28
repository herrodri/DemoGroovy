package com.grails.demogroovy.service

import com.grails.demogroovy.exception.InvalidInformationException
import grails.gorm.transactions.Transactional
import person.Person
import com.grails.demogroovy.dto.PersonDto
import com.grails.demogroovy.mapper.PersonMapper
import person.PersonService
import spock.lang.Specification


class CrudPersonServiceTest extends Specification{

    CrudPersonService crudPersonService = new CrudPersonService()

    PersonService personService

    PersonMapper personMapper

    void setup(){
        personService = Stub(PersonService.class)
        personMapper = Stub(PersonMapper.class)
        crudPersonService.setPersonService(personService)
        crudPersonService.setPersonMapper (personMapper)
    }

    void "given a new person with correct data should save the person correctly " () {

        given:
        PersonDto personDto = new PersonDto()
        personDto.setDocumentNumber("12345678")
        personDto.setFirstName("Andres")
        personDto.setLastName("Ortiz")
        personDto.setAge(25)

        Person personEntity = new Person()
        personEntity.setDocumentNumber("12345678")
        personEntity.setFirstName("Andres")
        personEntity.setLastName("Ortiz")
        personEntity.setAge(25)

        and:
        personService.findPersonByDocumentNumber("12345678") >> null
        personService.savePerson(Person.class) >> personEntity

        when:
        PersonDto personResult = crudPersonService.savePerson(personDto)

        then:
        personResult != null
    }

    void "given a person with incorrect data should be thrown InvalidInformationException "() {
        given:
        PersonDto personDto = new PersonDto()
        personDto.setDocumentNumber("12345")
        personDto.setFirstName("Andres")
        personDto.setLastName("Ortiz")
        personDto.setAge(25)

        when:
        PersonDto personResult = crudPersonService.savePerson(personDto)

        then:
        thrown InvalidInformationException
    }
}
