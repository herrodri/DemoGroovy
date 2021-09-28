package com.grails.demogroovy.exception

class InvalidInformationException extends Exception {

    InvalidInformationException(String errorMessage){
        super (errorMessage)
    }
}
