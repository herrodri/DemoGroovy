package com.grails.demogroovy.service

import com.grails.demogroovy.dto.PersonDto
import com.grails.demogroovy.exception.InvalidInformationException
import com.grails.demogroovy.mapper.PersonMapper
import person.Person
import person.PersonService

class CrudPersonService {

    PersonService personService

    PersonMapper personMapper

    PersonDto savePerson (PersonDto personDto) {
        try {
            validateInformationPerson(personDto)
            searchPersonByDocument(personDto.getDocumentNumber())
            return personMapper.fromEntityToDto(personService.savePerson(personMapper.fromDtoToEntity(personDto)))
        }
        catch (Exception exception) {
            if (exception instanceof InvalidInformationException) {
                throw new InvalidInformationException(exception.getMessage())
            }else {
                throw new Exception("Error guardando datos")
            }
        }
    }

    private void validateInformationPerson (PersonDto personDto){
        if (!personDto.validate()){
            throw new InvalidInformationException("Los datos ingresados son incorrectos")
        }
    }

    private void searchPersonByDocument (String documentNumber){
        Person person = personService.findPersonByDocumentNumber(documentNumber)
        if(person) {
            throw new InvalidInformationException("el usuario ya existe")
        }
    }
}
