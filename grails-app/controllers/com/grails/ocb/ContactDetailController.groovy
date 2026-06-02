package com.grails.ocb

import grails.converters.JSON
import ocb.Contact

class ContactDetailController {

    ContactDetailService contactDetailService
    ContactService contactService

    def create(){
        Contact contact=contactService.getById(params.id)
        [contactDetails: contactDetailService.getContactDetailsListByContact(contact)]
    }

    def delete(Integer id){
        render(contactDetailService.deleteContactDetails(id) as JSON)
    }
}
