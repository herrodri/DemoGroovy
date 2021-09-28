package com.grails.demogroovy.repository

import grails.gorm.transactions.Transactional
import org.grails.orm.hibernate.HibernateDatastore
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.PlatformTransactionManager
import person.Person
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@Transactional
class PersonRepositoryTest extends Specification {
    
    @Shared
    IPersonRepository personRepository

    @Shared
    @AutoCleanup
    HibernateDatastore hibernateDatastore

    @Shared
    PlatformTransactionManager transactionManager

    void setupSpec(){
        hibernateDatastore = new HibernateDatastore(Person)
        transactionManager = hibernateDatastore.getTransactionManager()
        personRepository = this.hibernateDatastore.getService(IPersonRepository)
    }

    @Rollback
    void "given a documentNumber of person should find a person "() {
        given:
        Person personTest = new Person(
                documentNumber: "12345678",
                firstName: "Pedro",
                lastName: "perez",
                age: 25).save()

        when:
        Person person = personRepository.findByDocumentNumber("12345678")

        then:
        person.documentNumber == personTest.documentNumber
    }
}
