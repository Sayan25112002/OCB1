package com.grails.ocb

class UIHelperTagLib {

    AuthenticationService authenticationService
    ContactGroupService contactGroupService

    static namespace = "UIHelper"

    def renderErrorMessage= { attrs, body ->
        def model = attrs.model
        String fieldName = attrs.fieldName
        String errorMessage = attrs.errorMessage ? g.message(code: attrs.errorMessage) : g.message(code: "invalid.input")
        if (model && model.errors && model.errors.getFieldError(fieldName)) {
            out << "<small class='form-text text-danger'><strong>${errorMessage}</strong></small>"
        }
    }

    // Define the closure properly
    def memberActionMenu = { attrs, body ->
        out<<'<li class="nav-item dropdown">'
        out<<'<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">'
        out<<authenticationService.getMemberName()
        out<<'</a>'
        out<<'<div class="dropdown-menu dropdown-menu-right">'
        out<<g.link(controller: "authentication", action: "logout", class: "dropdown-item") {
            out<< g.message(code: "logout")
        }
        out<<'</div></li>'
    }


    def leftNavigation = {attrs,body->
        List navigations = [
                [controller: "dashboard", action: "index", name:"dashboard"],
                [controller: "contactGroup", action: "index", name:"contact.group"],
                [controller: "contact", action: "index", name: "contact"]
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

    def contactGroup = {attrs,body->
        String name = attrs.name ?: "contactGroups"
        out<<g.select(class:"form-control",multiple: "multiple",optionValue: "name", optionKey: "id",value: "attrs.value",name: name, from: contactGroupService.contactGroupList())
    }
}
