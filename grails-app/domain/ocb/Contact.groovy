package ocb

class Contact {

    Integer id
    String name
    String image
    Member member

    Date dateCreated
    Date lastUpdated

    Set<ContactDetail> contactDetails
    Set<ContactGroup> contactGroups

    static hasMany = [contactDetails:ContactDetail, contactGroups:ContactGroup]

    static constraints = {
        image(
                nullable: true
        )
    }

    static mapping = {
        table name: 'Contact';
        id generator: 'org.hibernate.id.enhanced.TableGenerator',
                params: [
                        table_name         : 'MemberContact',
                        segment_column_name: 'table_names',
                        value_column_name  : 'next_id',
                        segment_value      : 'Contact_id'
                ]

        version(false)

        contactDetails cascade: "all-delete-orphan"

    }

}
