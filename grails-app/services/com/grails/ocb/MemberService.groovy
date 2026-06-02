package com.grails.ocb

import grails.web.servlet.mvc.GrailsParameterMap
import ocb.Member

class MemberService {

    AuthenticationService authenticationService

    def save(GrailsParameterMap params){
        Member member = new Member(params)
        def response = AppUtil.saveResponse(false,member)
        if(member.validate()){
            member.save(flush:true)
            if(!member.hasErrors()){
                response.isSuccess=true
            }
        }
        return response
    }

    def update(Member member, GrailsParameterMap params){
        member.properties=params
        def response = AppUtil.saveResponse(false,member)
        if(member.validate()){
            member.save(flush:true)
            if(!member.hasErrors()){
                response.isSuccess=true
            }
        }
        return response
    }

    def getById(Serializable id){
        return Member.get(id)
    }

    def list(GrailsParameterMap params){
        params.max = params.max?:GlobalConfig.itemsPerPage()
        List<Member> memberList = Member.createCriteria().list(params){
            if(params.colName && params.colValue){
                ilike(params.colName,"%"+params.colValue+"%")
            }
            if(!params.sort()){
                order("id","desc")
            }
        }
        return [list:memberList,count:Member.count()]
    }

    def delete(Member member){
        def currentMember = authenticationService.getMember()
        if(member.id==currentMember.id){
            return false
        }
        try{
            member.delete(flush: true)
        }catch(Exception e){
            println(e.getMessage())
            return false
        }
        return true
    }
}
