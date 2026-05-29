package com.grails.ocb

class MemberInterceptor {

    AuthenticationService authenticationService
    MemberService memberService

    boolean before(){
        if(authenticationService.isAdministrativeMember()){
            return true;
        }
        flash.message = AppUtil.infoMessage("You are not authorized for this action", false)
        redirect(controller:"dashboard",action:"index")
        return false
    }
}
