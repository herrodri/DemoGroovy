package com.grails.demogroovy

import com.grails.demogroovy.dto.Person
import com.grails.demogroovy.dto.PersonDto
import com.grails.demogroovy.dto.PersonService
import com.grails.demogroovy.mapper.PersonMapper
import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification


class PersonServiceSpec extends Specification  implements ServiceUnitTest<PersonService>, DataTest{

    PersonMapper personMapper
    Person person

    def setup() {
        personMapper = Mock(PersonMapper)
        person = Mock(Person)
        service.personMapper = personMapper
    }

    def cleanup() {
    }

    void "save a person when data is correct"() {
        given:
            PersonDto personDto = new PersonDto()
            personDto.setDocumentNumber("123456")
            personDto.setFirstName("Andres")
            personDto.setLastName("Gonzalez")
            personDto.setAge(34)

        Person personDb = new Person()
        personDb.setDocumentNumber("123456")
        personDb.setFirstName("Andres")
        personDb.setLastName("Gonzalez")
        personDb.setAge(34)
        personDb.setId(1)

        personMapper.fromDtoToEntity(_ as PersonDto ) >> personDb
        person.save() >> personDb

        when:
            PersonDto personResponse = service.save(personDto)

        then:
        assert personResponse.getDocumentNumber() == personDb.getDocumentNumber()
    }
}
