package com.grails.ocb

class UIHelperTagLib {

    AuthenticationService authenticationService

    static namespace = "UIHelper"

    def renderErrorMessage= { attrs, body ->
        def model = attrs.model
        String fieldName = attrs.fieldName
        String errorMessage = attrs.errorMessage ? g.message(code: attrs.errorMessage) : g.message(code: "invalid.input")
        if (model && model.errors && model.errors.getFieldError(fieldName)) {
            out << "<small class='form-text text-danger'><strong>${errorMessage}</strong></small>"
        }
    }

    def memberActionMenu = {attrs,body ->
        out<<'<li class="nav-item dropdown show">'
        out<<g.link(class:"nav-link dropdown-toggle","data-toggle":"dropdown"){authenticationService.getMemberName()}
        out<<'<div class="dropdown-menu">'
        out<<'<a class="dropdown-item" href="#">'
        out<<g.link(controller: "authentication", action: "logout", class:"dropdown-item"){g.message(code: "logout")}
        out<<"</a></div></li>"
    }

    def leftNavigation = {attrs,body->
        List navigations = [
                [controller: "dashboard", action: "index", name:"dashboard"]
        ]
        if(authenticationService.isAdministrativeMember()){
            navigations.add(controller: "member", action: "index", name:"member")
        }
        navigations.each {menu->
            out<<'<li class="list-group-item">'
            out<<g.link(controller: menu.controller, action: menu.action) {g.message(code: menu.name, args: [''])}
            out<<"</li>"
        }
    }
}
