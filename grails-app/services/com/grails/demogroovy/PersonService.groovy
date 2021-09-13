package com.grails.demogroovy

import grails.gorm.transactions.Transactional

@Transactional
class PersonService {

    def save (person){
        println("person en service")
        println(person)
        person.save()
    }

    def get(id){
        Person.get(id)
    }

    def listPerson(){
        Person.list()
    }
}
