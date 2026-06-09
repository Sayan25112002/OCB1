package ocb

class ContactDetail {

    Integer id
    String mobile
    String phone
    String email
    String website
    String address
    String type
    Contact contact

    Date dateCreated
    Date lastUpdated

    static constraints = {
        mobile(
                nullable: true,
                blank: true
        )
        phone(
                nullable: true,
                blank: true
        )
        email(
                nullable: true,
                blank: true
        )
        website(
                nullable: true,
                blank: true
        )
        address(
                nullable: true,
                blank: true
        )
    }

    static mapping = {
        table name: 'ContactDetail';
        id generator: 'org.hibernate.id.enhanced.TableGenerator',
                params: [
                        table_name         : 'MemberContact',
                        segment_column_name: 'table_names',
                        value_column_name  : 'next_id',
                        segment_value      : 'ContactDetail_id'
                ]

        version(false)
    }
}
