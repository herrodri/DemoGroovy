package com.grails.demogroovy

class UrlMappings {

    static mappings = {
        //default mappings
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        //mapping person
        '/person'(resources: 'person'){
            collection {
                post "/save"(controller:'person', action:'save')
                get "/show/$id?"(controller:'person', action: 'show')
                get "/list"(controller:'person', action: 'list')
            }
        }

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
