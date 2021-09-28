package person

import com.grails.demogroovy.dto.PersonDto
import com.grails.demogroovy.service.CrudPersonService
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class PersonController {

	static responseFormats = ['json', 'xml']

    CrudPersonService crudPersonService

    PersonDto save(PersonDto personDto){
        respond(crudPersonService.savePerson(personDto)) as PersonDto
    }
}
