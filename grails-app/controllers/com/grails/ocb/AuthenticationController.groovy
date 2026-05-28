package com.grails.ocb

class AuthenticationController {

    AuthenticationService authenticationService
    MemberService memberService

    def login() {
        if(authenticationService.isAuthenticated()){
            redirect(controller:"dashboard", action:"index")
        }
    }

    def doLogin(){
        if(authenticationService.doLogin(params.email,params.password)){
            flash.message = AppUtil.infoMessage(g.message(code: "successfully.login"),true)
            redirect(controller: "dashboard", action: "index")
        }else{
            flash.message = AppUtil.infoMessage(g.message(code:"unable.to.login"),false)
            redirect(controller: "authentication", action: "login")
        }
    }

    def logout(){
        session.invalidate()
        redirect(controller: "authentication", action: "login")
    }

    def registration(){
        [member:flash.redirectParams]
    }

    def doRegistration(){
        def response = memberService.save(params)
        if(response.isSuccess){
            flash.message = AppUtil.infoMessage(g.message(code:"successfully.registered"),true)
            redirect(controller: "authentication", action: "login")
        }else {
            flash.redirectParams = response.model
            flash.message = AppUtil.infoMessage(g.message(code:"unable.to.register"),false)
            redirect(controller: "authentication", action: "registration")
        }
    }
}
