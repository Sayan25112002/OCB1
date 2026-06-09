package ocb

class ContactGroup {

    Integer id
    String name
    Member member

    Date dateCreated
    Date lastUpdated

    static belongsTo = [Member,Contact]
    static hasMany = [contact:Contact]

    static constraints = {
        name(
                blank:false,
                nullable: false
        )
        member(nullable: true)
    }

    static mapping = {
        table name: 'ContactGroup';
        id generator : 'org.hibernate.id.enhanced.TableGenerator',
                params:[
                        table_name:'MemberContact',
                        segment_column_name:'table_names',
                        value_column_name:'next_id',
                        segment_value:'ContactGroup_id'
                ]

        version(false)
    }
}
