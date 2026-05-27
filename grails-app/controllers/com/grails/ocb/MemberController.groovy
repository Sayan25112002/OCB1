package com.grails.ocb

class MemberController {

    MemberService memberService

    def index() {
        def response = memberService.list(params)
        [memberList:response.list , total:response.count]
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

    def save(){
        def response = memberService.save(params)
        if(!response.isSuccess){
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code: "unable.to.save"),false)
            redirect(controller: "member", action: "create")
        }else{
            flash.message = AppUtil.infoMessage(g.message(code: "saved"),true)
            redirect(controller: "member", action: "index")
        }
    }

    def edit(Integer id){
        if(flash.redirectParams){
            [member: flash.redirectParams]
        }else{
            def response = memberService.getById(id)
            if(!response){
                redirect(controller: "member", action: "index")
            }
            else{
                [member:response]
            }
        }
    }

    def update(){
        def response = memberService.getById(params.id)
        if(!response){
            redirect(controller: "member", action: "index")
        }else{
            response = memberService.update(response,params)
            if(!response.isSuccess){
                flash.redirectParams=response.model
                flash.message = AppUtil.infoMessage(g.message(code:"unable.to.update"),false)
                redirect(controller: "member", action: "edit")
            }else{
                flash.message = AppUtil.infoMessage(g.message(code:"updated"),true)
                redirect(controller: "member", action: "index")
            }
        }
    }

    def delete(Integer id){
        def response = memberService.getById(id)
        if(!response){
            flash.message = AppUtil.infoMessage(g.message(code:"unable.to.delete"),false)
            redirect(controller: "member", action: "index")
        }else{
            memberService.delete(response)
            flash.message = AppUtil.infoMessage(g.message(code:"deleted"),true)
            redirect(controller: "member", action:"index")
        }
    }
}
