package com.grails.demogroovy

import grails.rest.*
import grails.converters.*
import groovy.transform.CompileStatic

class PersonController {

	static responseFormats = ['json', 'xml']

    def personService

    def save(){
        println("entro a save")
        println(request.JSON)
        def personObject = new Person(request.JSON as Map)
        println(personObject)
        personService.save(personObject)
    }

    def show(Long id){
        println("llego a show")
        println(id)
        respond personService.get(id)
    }

    def list(){
        respond personService.listPerson()
    }
}
