package com.grails.demogroovy.dto

class Person {
    String documentNumber
    String firstName
    String lastName
    int age

    static constraints = {
        documentNumber(minSize: 8,  maxSize: 12, blank: false, unique: true)
        firstName(maxSize: 15, blank: false)
        lastName(maxSize: 15, blank: false)
        age(min: 18, blank: false)
    }
}
