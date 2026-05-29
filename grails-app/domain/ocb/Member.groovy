package ocb

import com.grails.ocb.GlobalConfig

class Member {

    Integer id
    String firstName
    String lastName
    String email
    String password
    String memberType = GlobalConfig.USER_TYPE.REGULAR_MEMBER
    String identityHash
    Date identityHashLastActive
    Boolean isActive = true

    Date dateCreated
    Date lastUpdated

    static hasMany = [contact:Contact, contactGroup:ContactGroup]

    static constraints = {
        email(email: true, nullable: false, unique: true, blank: false)
        password(blank: false)
        lastName(nullable: true)
        identityHash(nullable: true)
        identityHashLastActive(nullable: true)
    }

    def beforeInsert(){
        this.password = this.password.encodeAsMD5()
    }

    def afterInsert(){
        this.password = this.password.encodeAsMD5()
    }
}
