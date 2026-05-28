package com.grails.ocb

import ocb.Member

class AppInitializationService {

    static initialize(){
        initMember()
    }

    private static initMember(){
        if(Member.count==0){
            Member member=new Member()
            member.firstName="System"
            member.lastName="Administrator"
            member.email="obc@domain.com"
            member.password="123456"
            member.memberType=GlobalConfig.USER_TYPE.ADMINISTRATOR
            member.save(flash:true)
        }
    }
}
