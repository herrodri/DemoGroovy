import com.grails.demogroovy.dto.PersonService
import com.grails.demogroovy.mapper.PersonMapper

// Place your Spring DSL code here
beans = {

    personService(PersonService) {bean ->
        bean.autowire = "byName"
    }

    personMapper(PersonMapper) { bean ->
        bean.autowire = "byName"
    }
}
