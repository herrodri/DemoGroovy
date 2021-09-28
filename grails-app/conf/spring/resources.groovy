import com.grails.demogroovy.mapper.PersonMapper
import com.grails.demogroovy.service.CrudPersonService

// Place your Spring DSL code here
beans = {

    crudPersonService(CrudPersonService){ bean ->
        bean.autowire = "byName"
    }

    personMapper(PersonMapper) { bean ->
        bean.autowire = "byName"
    }
}
