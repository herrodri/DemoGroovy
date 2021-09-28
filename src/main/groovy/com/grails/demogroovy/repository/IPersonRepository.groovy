package com.grails.demogroovy.repository

import person.Person

interface IPersonRepository {

    Person save(Person person)

    Person findByDocumentNumber(String documentNumber)

}