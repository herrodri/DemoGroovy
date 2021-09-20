package com.grails.demogroovy.dto

class PersonController {

	static responseFormats = ['json', 'xml']

    def personService

    PersonDto save(PersonDto personDto){
        respond personService.save(personDto)
    }

    PersonDto show(Long id){
        respond personService.get(id)
    }

    List<PersonDto> list(){
        respond personService.listPerson()
    }
}
