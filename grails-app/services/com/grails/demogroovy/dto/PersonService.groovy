package com.grails.demogroovy.dto


import com.grails.demogroovy.mapper.PersonMapper

class PersonService {

     PersonMapper personMapper

    PersonDto save (PersonDto personDto){
        if (searchPersonByDocument(personDto.getDocumentNumber())){
            return personDto
        } else {
            try {
                personDto.validate()
                Person person = personMapper.fromDtoToEntity(personDto)
                person.save()
                return personDto

            }catch (Exception ex) {
                throw new Exception ("invalid data")
                println(ex.getMessage())
            }
        }
    }

    PersonDto get(id){
        try{
            return personMapper.fromEntityToDto(Person.get(id))
        } catch(Exception) {
            throw new Exception (" information not found")
            println(ex.getMessage())
        }
    }

    List<PersonDto> listPerson(){
        List<PersonDto> listPersonsDto = new ArrayList<>()
        try{
            Person.list().each {it -> listPersonsDto.add(personMapper.fromEntityToDto(it))}
            return listPersonsDto
        } catch (Exception ex) {
            throw new Exception ("information not found")
            println(ex.getMessage())
        }
    }

    private boolean searchPersonByDocument (String documentNumber){
        return Person.findByDocumentNumber(documentNumber)? true : false
    }
}
