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

    Set<Course> courses

    static hasMany = [
            contact:Contact,
            contactGroup:ContactGroup,
            courses:Course
    ]

    static constraints = {
        email(
                email: true,
                nullable: false,
                unique: true,
                blank: false
        )
        password(
                blank: false,
                nullable: false,
                validator: {val,obj->
                    if(obj.id){
                        return true
                    }
                    return val==~/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*_])[A-Za-z\d!@#$%^&*_]{8,}/
                }
        )
        lastName(
                nullable: true
        )
        identityHash(
                nullable: true
        )
        identityHashLastActive(
                nullable: true
        )
    }

    def beforeInsert(){
        this.password = this.password.encodeAsMD5()
    }

    def afterInsert(){
        this.password = this.password.encodeAsMD5()
    }

    static mapping = {
        table name: 'Member';
        id generator : 'org.hibernate.id.enhanced.TableGenerator',
            params:[
                    table_name:'MemberContact',
                    segment_column_name:'table_names',
                    value_column_name:'next_id',
                    segment_value:'Member_id'
            ]

        version(false)
    }
}
