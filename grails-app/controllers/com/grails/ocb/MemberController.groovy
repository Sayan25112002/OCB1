package com.grails.ocb

class MemberController {

    MemberService memberService

    def index() {
        def response = memberService.list(params)
        [member:response.list , total:response.count]
    }

    def details(Integer id){
        def response = memberService.getById(id)
        if(!response){
            redirect(controller:"member",action:"index")
        }else{
            [member:response]
        }
    }

    def create(){
        [member: flash.redirectParams]
    }
}
