package com.grails.ocb

import ocb.Contact

class ContactController {

    ContactService contactService

    def index(){
        def response = contactService.list(params)
        [contacts:response.list, total: response.count]
    }

    def details(Integer id){
        def response=contactService.getById(id)
        if(!response){
            redirect(controller:"contact",action:"index")
        }else{
            [contact: response]
        }
    }

    def create(){
        [contact: flash.redirectParams]
    }

    def save(){
        def response = contactService.save(params)
        if(!response.isSuccess){
            flash.message = AppUtil.infoMessage(g.message(code:"unable.to.save"),false)
            redirect(controller: "contact", action:"create")
        }else {
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code:"saved"),true)
            redirect(controller: "contact", action: "index")
        }
    }

    def edit(Integer id){
        if(flash.redirectParams){
            [contact: flash.redirectParams]
        }else{
            def response = contactService.getById(id)
            if(!response){
                flash.message=AppUtil.infoMessage(g.message(code:"invalid.entity"),false)
                redirect(controller: "contact", action:"index")
            }else{
                [contact: response]
            }
        }
    }

    def update(){
        def response = contactService.getById(params.id)
        if(!response){
            flash.message=AppUtil.infoMessage(g.message(code:"invalid.entity"),false)
            redirect(controller: "contact", action: "index")
        }else{
            response = contactService.update(response,params)
            if(!response.isSuccess){
                flash.redirectParams = response.model
                flash.message=AppUtil.infoMessage(g.message(code:"unable.to.update"),false)
                redirect(controller: "contact", action:"edit")
            }else{
                flash.message=AppUtil.infoMessage(g.message(code:"updated"),true)
                redirect(controller: "contact",action: "index")
            }
        }
    }

    def delete(Integer id){
        def response = contactService.getById(id)
        if(!response){
            flash.message = AppUtil.infoMessage(g.message(code:"invalid.entity"),false)
            redirect(controller: "contact", action: "index")
        }else{
            response=contactService.delete(response)
            if(!response){
                flash.message = AppUtil.infoMessage(g.message(code:"unable.to.delete"),false)
            }else{
                flash.message = AppUtil.infoMessage(g.message(code:"deleted"),true)
            }
        }
        redirect(controller: "contact", action: "index")
    }
}
