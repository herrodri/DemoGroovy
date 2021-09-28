package person


import com.grails.demogroovy.repository.IPersonRepository
import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Service(Person)
abstract class PersonService implements IPersonRepository {

    @Transactional
    Person savePerson(Person person) {
        save(person)
    }

    Person findPersonByDocumentNumber (String documentNumber){
        return findByDocumentNumber(documentNumber)
    }
}
