package ocb

class Course {

    Integer id
    String courseName
    String courseType

    static belongsTo = [Member]
    static hasMany = [members:Member]

    static constraints = {
        courseName(nullable: false,blank: false)
        courseType(nullable: false, blank: false)
    }

    static mapping = {
        table name:'Course';
        id generator : 'org.hibernate.id.enhanced.TableGenerator',
            params:[
                table_name:'MemberContact',
                segment_column_name:'table_names',
                value_column_name:'next_id',
                segment_value:'Course_id'
            ]
        version(false)
    }
}
