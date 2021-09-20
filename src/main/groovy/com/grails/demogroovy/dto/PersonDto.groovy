package com.grails.demogroovy.dto

import grails.validation.Validateable

class PersonDto implements Validateable{

    String documentNumber
    String firstName
    String lastName
    int age

    static constraints = {
        documentNumber(minSize: 8,  maxSize: 12, blank: false, nullable: false)
        firstName(maxSize: 15, blank: false, nullable: false)
        lastName(maxSize: 15, blank: false , nullable: false)
        age(min: 18, blank: false, nullable: false)
    }

}
