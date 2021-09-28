package com.grails.demogroovy.mapper

import person.Person
import com.grails.demogroovy.dto.PersonDto

class PersonMapper {

    static Person fromDtoToEntity (PersonDto personDto){
        return new Person(
                documentNumber: personDto.getDocumentNumber(),
                firstName: personDto.getFirstName(),
                lastName: personDto.getLastName(),
                age: personDto.getAge())
    }

    static PersonDto fromEntityToDto (Person person){
        PersonDto personDto = new PersonDto()
        personDto.setDocumentNumber(person.getDocumentNumber())
        personDto.setFirstName(person.getFirstName())
        personDto.setLastName(person.getLastName())
        personDto.setAge(person.getAge())

        return personDto
    }
}
