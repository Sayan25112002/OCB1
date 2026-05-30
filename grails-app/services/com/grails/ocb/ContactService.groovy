package com.grails.ocb

import grails.web.servlet.mvc.GrailsParameterMap
import ocb.Contact

import javax.servlet.http.HttpServletRequest

class ContactService {

    AuthenticationService authenticationService

    def save(GrailsParameterMap params){
        Contact contact = new Contact(params)
        contact.member=authenticationService.getMember()
        def response = AppUtil.saveResponse(false, contact)
        if(contact.validate()){
            contact.save(flush:true)
            if(!contact.hasErrors()){
                response.isSuccess=true
            }
        }
        return response
    }

    def update(Contact contact, GrailsParameterMap params){
        contact.properties=params
        def response = AppUtil.saveResponse(false,contact)
        if(contact.validate()){
            contact.save(flush:true)
            if(!contact.hasErrors()){
                response.isSuccess=true
            }
        }
        return response
    }

    def getById(Serializable id){
        return Contact.get(id)
    }

    def list(GrailsParameterMap params){
        params.max=params.max?:GlobalConfig.itemsPerPage()
        List<Contact> contacts = Contact.createCriteria().list(params) {
            if(params?.colName && params?.colValue){
                like(params.colName,"%"+params.colValue+"%")
            }
            if(!params.sort){
                order("id","desc")
            }
            eq("member",authenticationService.getMember())
        }
        return [list:contacts, count:Contact.count()]
    }

    def delete(Contact contact){
        try{
            contact.delete(flush: true)
        }catch (Exception e){
            println(e.getMessage())
            return false
        }
        return true
    }
}
