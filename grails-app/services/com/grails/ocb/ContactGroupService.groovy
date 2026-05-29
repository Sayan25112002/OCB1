package com.grails.ocb

import grails.web.servlet.mvc.GrailsParameterMap
import ocb.ContactGroup

class ContactGroupService {

    AuthenticationService authenticationService

    def save(def params){
        ContactGroup contactGroup=new ContactGroup(params)
        contactGroup.member=authenticationService.member
        def response = AppUtil.saveResponse(false,contactGroup)
        if(contactGroup.validate()){
            response.isSuccess=true
            contactGroup.save()
        }
        return response
    }

    def update(ContactGroup contactGroup, GrailsParameterMap params){
        contactGroup.properties=params
        def response = AppUtil.saveResponse(false,contactGroup)
        if(contactGroup.validate()){
            response.isSuccess=true
            contactGroup.save()
        }
        return response
    }

    def get(Serializable id){
        return ContactGroup.get(id)
    }

    def list(GrailsParameterMap params){
        params.max = params.max?:GlobalConfig.itemsPerPage()
        List<ContactGroup> contactGroups = ContactGroup.createCriteria().list(params){
            if(params?.colName && params?.colValue){
                like(params.colName,"%"+params.colValue+"%")
            }
            if(!params.sort){
                order("id","desc")
            }
            eq("member",authenticationService.getMember())
        }
        return [list:contactGroups, count:ContactGroup.count()]
    }

    def contactGroupList(){
        return ContactGroup.createCriteria().list{
            eq("member",authenticationService.getMember())
        }
    }

    def cleanContactGroupById(Integer id){
        ContactGroup contactGroup = ContactGroup.get(id)
        contactGroup.contact.each {contact->
            contact.removeFromContactGroups(contactGroup)
        }
        contactGroup.save(flush:true)
    }

    def delete(){
        try{
            cleanContactGroupById(contactGroup.id)
            contactGroup.delete(flush: true)
        }catch (Exception e){
            println(e.getMessage())
            return false
        }
        return true
    }
}
